package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vo.BoardVO;

@Repository
public class BookMarkDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<BoardVO> mapper = new RowMapper<BoardVO>() {
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setNum(rs.getInt("num"));
		boardVO.setAddr(rs.getString("addr"));
		boardVO.setHosname(rs.getString("hosname"));
		boardVO.setTel(rs.getString("tel"));
		return boardVO;
		}
	};
	
	
	public List<BoardVO> selectBookMarkList() {
		String sql = "SELECT * FROM bookmark";
		
		List<BoardVO> bookmarkList = jdbcTemplate.query(sql, mapper);
//		System.out.println(System.identityHashCode(bookmarkList));
//		System.out.println(bookmarkList.toString());
		return bookmarkList;
	}


	public void deleteBookmark(int num) {
		String sql = "DELETE bookmark WHERE num = ?";
		Object[] values = new Object[] {
				num
		};
		jdbcTemplate.update(sql, values);
		
	}


	public List<BoardVO> selectArticleList(int startRow, int pageSize) {
String sql = "SELECT lwr.* FROM (SELECT ROWNUM rn, b.* FROM (SELECT * FROM bookmark order by num desc) b) lwr WHERE rn between ? and ?";
		
		int endRow = startRow+pageSize-1;
		Object[] values = new Object[] {
				startRow, endRow
		};
		System.out.println("startRow:" + startRow + "/" + "endRow" + endRow);
		List<BoardVO> articleList = jdbcTemplate.query(sql, values, mapper);
		
		return articleList;
	}


	public void registBookMark(String user_id, String name, String addr, String tel) {
	      String sql = "INSERT INTO bookmark(num, hosname, tel, addr)" +
	                  " VALUES(bookmark_seq.nextval, ?, ?, ?)";
	      Object[] values = new Object[] {
	            name, tel, addr
	      };
	      jdbcTemplate.update(sql, values);
	   }

}
