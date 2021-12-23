package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.BoardVO;
import vo.DateVO;
import vo.HospResvVO;
import vo.HospVO;
import vo.PetVO;
import vo.UserVO;

public class HospResvDAO {
	private static Connection con;
	//singleton 패턴
	
	private static HospResvDAO instance;
	
	private HospResvDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static HospResvDAO getInstance() {
		if(instance == null) {
			instance = new HospResvDAO();
		}
		
		return instance;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
		
	}

	public ArrayList<HospResvVO> selectselfResv(String user_id) {
		// TODO Auto-generated method stub
		ArrayList<HospResvVO> resvList = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from hospresvtime where user_id = ? order by tprimary, time_num";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resvList = new ArrayList<HospResvVO>();
				HospResvVO hospResvVO = null;

				do {
					hospResvVO = new HospResvVO();
					hospResvVO.setTprimary(rs.getInt("tprimary"));
					hospResvVO.setTime_num(rs.getInt("time_num"));
					hospResvVO.setResvdate(rs.getString("resvdate"));
					hospResvVO.setHos_name(rs.getString("hos_name"));
					hospResvVO.setPet_name(rs.getString("pet_name"));
					
					resvList.add(hospResvVO);

				}
				while(rs.next());

			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return resvList;
	}

	public ArrayList<PetVO> selectResvPet(String user_id, ArrayList<HospResvVO> findresv) {
		// TODO Auto-generated method stub
		ArrayList<PetVO> resvList = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String sql = "select pi.* from petinfo pi, hospresvtime rsv "
				+ "where rsv.user_id = ? and rsv.user_id = pi.user_id and (rsv.pet_name = pi.pet_Name) "
				+ "order by rsv.tprimary, rsv.time_num";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				resvList = new ArrayList<PetVO>();
				PetVO resvpetVO = null;

				do {
					resvpetVO = new PetVO();
					resvpetVO.setPet_Age(rs.getInt("pet_Age"));
					resvpetVO.setPet_Name(rs.getString("pet_Name"));
					resvpetVO.setPet_Kind(rs.getString("pet_Kind"));
					resvpetVO.setPet_Gender(rs.getString("pet_Gender"));
					resvpetVO.setPet_Weight(rs.getFloat("pet_Weight"));
					resvpetVO.setPet_Disease(rs.getString("pet_Disease"));
					resvpetVO.setPet_Infodetail(rs.getString("pet_Infodetail"));
					resvList.add(resvpetVO);

				}
				while(rs.next());

			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return resvList;
	}

	public ArrayList<DateVO> selectResvDate(String user_id, ArrayList<HospResvVO> findresv) {
		// TODO Auto-generated method stub
		ArrayList<DateVO> resvList = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String sql = "select di.*, hsv.* from hospresvtime hsv, dateinfo di "
				+ "where hsv.user_id = ? and di.tprimary = hsv.tprimary "
				+ "order by hsv.tprimary, hsv.time_num";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				resvList = new ArrayList<DateVO>();
				DateVO resvDateVO = null;

				do {
					resvDateVO = new DateVO();
					resvDateVO.setRdate(rs.getString("rdate"));
					resvList.add(resvDateVO);

				}
				while(rs.next());

			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return resvList;
	}

	public int updateResv(String[] tp, String[] timearr) {
		// TODO Auto-generated method stub
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try {
			for (int i = 0; i < tp.length; i++) {
				String sql = "update hospresvtime set user_id = ?, hos_name = ?, pet_name = ? "
						+ "where tprimary = ? and time_num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, null);
				pstmt.setString(2, null);
				pstmt.setString(3, null);
				pstmt.setString(4, tp[i]);
				pstmt.setString(5, timearr[i]);
				updateCount = pstmt.executeUpdate();

			}
					
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCount;
	}

	public int selectArticleCount(String user_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int articleCount = 0;
		try {
			pstmt = con.prepareStatement("select count(*) FROM hospresvtime hos, dateinfo di "
					+ "where di.tprimary = hos.tprimary and "
					+ "di.d_num = (select d_num from HOSINFO where user_id = ?) and "
					+ "hos.user_id is not null "
					+ "order by hos.tprimary, hos.time_num");
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleCount = rs.getInt(1);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return articleCount;
	}

	public List<HospResvVO> selectResvList(int startRow, int pageSize, String user_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HospResvVO> resvList = null;
		try {
			pstmt = con.prepareStatement(""
					+ "SELECT list2.* FROM (SELECT ROWNUM r, list1.* "
					+ "FROM (select hos.* "
					+ "FROM hospresvtime hos, dateinfo di "
					+ "where di.tprimary = hos.tprimary and "
					+ "di.d_num = (select d_num from HOSINFO "
					+ "where user_id = ?) and "
					+ "hos.user_id is not null "
					+ "order by hos.tprimary, hos.time_num) list1) list2 WHERE r BETWEEN ? AND ?");
			pstmt.setString(1, user_id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, startRow + pageSize - 1);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				resvList = new ArrayList<HospResvVO>();

				do {
					HospResvVO hospResvVO = new HospResvVO();
					hospResvVO.setTprimary(rs.getInt("tprimary"));
					hospResvVO.setRt(rs.getString("resv_time"));
					hospResvVO.setPet_name(rs.getString("pet_name"));
					resvList.add(hospResvVO);
					
				} while (rs.next());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return resvList;
	}

	public List<DateVO> selectResvDateList(int startRow, int pageSize, String user_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DateVO> resvDateList = null;
		
		try {
			pstmt = con.prepareStatement(""
					+ "SELECT list2.* FROM (SELECT ROWNUM r, list1.* "
					+ "FROM (select di.rdate, hos.* "
					+ "FROM hospresvtime hos, dateinfo di "
					+ "where di.tprimary = hos.tprimary and "
					+ "di.d_num = (select d_num from HOSINFO "
					+ "where user_id = ?) and "
					+ "hos.user_id is not null "
					+ "order by hos.tprimary, hos.time_num) list1) list2 WHERE r BETWEEN ? AND ?");
			pstmt.setString(1, user_id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, startRow + pageSize - 1);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				resvDateList = new ArrayList<DateVO>();

				do {
					DateVO dateVO = new DateVO();
					dateVO.setRdate(rs.getString("rdate"));
					resvDateList.add(dateVO);
					
				} while (rs.next());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return resvDateList;
	}

	public List<UserVO> selectResvNameList(int startRow, int pageSize, String user_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> resvNameList = null;
		
		try {
			pstmt = con.prepareStatement(""
					+ "SELECT list2.* FROM (SELECT ROWNUM r, list1.* "
					+ "FROM (select hos.*, ui.user_name, ui.user_phone "
					+ "FROM hospresvtime hos, dateinfo di, userInfo ui "
					+ "where ui.user_id = hos.user_id and di.tprimary = hos.tprimary and "
					+ "di.d_num = (select d_num from HOSINFO where user_id = ?) and "
					+ "hos.user_id is not null order by hos.tprimary, hos.time_num) list1) list2 "
					+ "WHERE r BETWEEN ? AND ?");
			pstmt.setString(1, user_id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, startRow + pageSize - 1);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				resvNameList = new ArrayList<UserVO>();

				do {
					UserVO userVO = new UserVO();
					userVO.setUser_name(rs.getString("user_name"));
					userVO.setUser_phone(Integer.toString(rs.getInt("user_phone")));
					userVO.setUser_id(rs.getString("user_id"));
					resvNameList.add(userVO);
					
				} while (rs.next());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return resvNameList;
	}

	public List<HospVO> selectResvHosList(int startRow, int pageSize, String user_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HospVO> resvHosList = null;
		
		try {
			pstmt = con.prepareStatement(""
					+ "SELECT list2.* FROM (SELECT ROWNUM r, list1.* "
					+ "FROM (select hos.*, h.Hosp_tel "
					+ "FROM hospresvtime hos, dateinfo di, hosinfo h "
					+ "where h.user_id =? and di.tprimary = hos.tprimary and "
					+ "di.d_num = (select d_num from HOSINFO where user_id=?) and "
					+ "hos.user_id is not null order by hos.tprimary, hos.time_num) list1) list2 "
					+ "WHERE r BETWEEN ? AND ?");
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_id);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, startRow + pageSize - 1);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				resvHosList = new ArrayList<HospVO>();

				do {
					HospVO hospVO = new HospVO();
					hospVO.setHosp_tel(rs.getString("Hosp_tel"));
					resvHosList.add(hospVO);
					
				} while (rs.next());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return resvHosList;
	}

	public PetVO selectResverInfo(HospResvVO hospResvVO, DateVO dateVO, UserVO userVO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PetVO petVO = new PetVO();
		try {
			String sql = "select * from petinfo where user_id = ? and pet_Name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userVO.getUser_id());
			pstmt.setString(2, hospResvVO.getPet_name());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				petVO.setPet_Name(rs.getString("pet_Name"));
				petVO.setPet_Age(rs.getInt("pet_Age"));
				petVO.setPet_Kind(rs.getString("pet_Kind"));
				petVO.setPet_Gender(rs.getString("pet_Gender"));
				petVO.setPet_Weight(rs.getFloat("pet_Weight"));
				petVO.setPet_Disease(rs.getString("pet_Disease"));
				petVO.setPet_Infodetail(rs.getString("pet_Infodetail"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return petVO;
	}

	public int updatefinTreat(int tprimary, String user_id, String username, String rdate, String rt, String petname, String petInfodetail) {
		// TODO Auto-generated method stub
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try {
			
				String sql = "update hospresvtime set fintreat = ? "
						+ "where tprimary = ? and resv_time = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, 2);
				pstmt.setInt(2, tprimary);
				pstmt.setString(3, rt);
			
				updateCount = pstmt.executeUpdate();

			
					
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCount;
	}
	
}
