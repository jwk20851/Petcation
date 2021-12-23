package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vo.PetVO;

@Repository
public class PetDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<PetVO> mapper = new RowMapper<PetVO>() {
		public PetVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			PetVO petVO = new PetVO();
			petVO.setPet_Num(rs.getString("pet_Num"));
			petVO.setUser_Id(rs.getString("user_Id"));
			petVO.setPet_Kind(rs.getString("pet_Kind"));
			petVO.setPet_Name(rs.getString("pet_Name"));
			petVO.setPet_Age(rs.getInt("pet_Age"));
			petVO.setPet_Breed(rs.getString("pet_Breed"));
			petVO.setPet_Gender(rs.getString("pet_Gender"));
			petVO.setPet_Weight(rs.getFloat("pet_Weight"));
			petVO.setPet_Disease(rs.getString("pet_Disease"));
			petVO.setPet_Infodetail(rs.getString("pet_Infodetail"));
			petVO.setPet_Filename(rs.getString("pet_Filename"));
			return petVO;
			}
		};
	
	
	private static Connection con;
	// singleton �뙣�꽩

	private static PetDAO instance;

	private PetDAO() {
		// TODO Auto-generated constructor stub
	}

	public static PetDAO getInstance() {
		if (instance == null) {
			instance = new PetDAO();
		}

		return instance;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;

	}

	public int insertPet(PetVO petVO) {
		// TODO Auto-generated method stub
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO petinfo(pet_Num, user_Id, pet_Age, pet_Breed, pet_Disease, pet_Gender,"
				+ "pet_Infodetail, pet_Kind, pet_Name, pet_Weight, pet_Filename) VALUES(petnum_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, petVO.getUser_Id());
			pstmt.setInt(2, petVO.getPet_Age());
			pstmt.setString(3, petVO.getPet_Breed());
			pstmt.setString(4, petVO.getPet_Disease());
			pstmt.setString(5, petVO.getPet_Gender());
			pstmt.setString(6, petVO.getPet_Infodetail());
			pstmt.setString(7, petVO.getPet_Kind());
			pstmt.setString(8, petVO.getPet_Name());
			pstmt.setFloat(9, petVO.getPet_Weight());
			pstmt.setString(10, petVO.getPet_Filename());

			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
		
	}

	public ArrayList<PetVO> selectPetinfo(String user_id) {
		// TODO Auto-generated method stub
		ArrayList<PetVO> petList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from petinfo where user_Id = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				petList = new ArrayList<PetVO>();
				PetVO petVO = null;
				do {
					petVO = new PetVO();
					petVO.setPet_Name(rs.getString("pet_Name"));
					petList.add(petVO);
				} while (rs.next());
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return petList;
	}
	
	/*public List<PetVO> selectBoardList() {
		String sql = "SELECT * FROM petinfo ORDER BY pet_Num DESC";
		
		List<PetVO> petInfoList = jdbcTemplate.query(sql,mapper);
		System.out.println("다오:"+petInfoList);
		return petInfoList;
	}*/
	public List<PetVO> selectBoardList(String uid) {
		String user_Id = uid;
		String sql = "SELECT * FROM petinfo WHERE user_Id = ? ORDER BY pet_Num DESC";
		Object[] values = new Object[] {
				user_Id
		};
		List<PetVO> petInfoList = jdbcTemplate.query(sql, values, mapper);
		return petInfoList;
	}

	public void deletePetInfo(String[] delete1) {
		String sql = "";
		Object[] values = new Object[] {};
		System.out.println(Arrays.toString(delete1));
		for (int i = 0; i < delete1.length; i++) {
           	sql = "DELETE FROM petinfo WHERE pet_Num = ?";
           	values = new Object[] {
    				delete1[i]
    		};
           	System.out.println("delete1[i]: "+delete1[i]);
    		jdbcTemplate.update(sql, values);
	    }
	}

}
