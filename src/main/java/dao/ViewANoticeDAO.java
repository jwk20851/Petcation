package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vo.BoardVO;

@Repository
public class ViewANoticeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<BoardVO> mapper = new RowMapper<BoardVO>() {
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO boardVO = new BoardVO();
			
			boardVO.setNum(rs.getInt("num"));
			boardVO.setCheckbox(rs.getString("checkbox"));
			boardVO.setTitle(rs.getString("title"));
			boardVO.setContent(rs.getString("content"));
			boardVO.setNoticefile(rs.getString("noticefile"));
			boardVO.setReadcount(rs.getInt("readcount"));
			boardVO.setWriter(rs.getString("writer"));
			boardVO.setReg_date(rs.getTimestamp("reg_date"));
			
			return boardVO;
			}
		};
	
	
	//list
	public List<BoardVO> selectViewANoticeList() {
		String sql = "SELECT * FROM viewnotice ORDER BY num DESC";
		List<BoardVO> viewANoticeList = jdbcTemplate.query(sql, mapper);
		return viewANoticeList;
	}
	//write
	public void insertANotice(BoardVO boardVO) {
		String sql = "INSERT INTO viewnotice(num, title, content, noticefile, reg_date)"
				+ "VALUES(viewnotice_seq.nextval, ?, ?, ?, sysdate)";
		
		Object[] values = new Object[] {
				boardVO.getTitle(),
				boardVO.getContent(),
				boardVO.getNoticefile()
				
		};
		
		jdbcTemplate.update(sql, values);
		
	}


	public BoardVO selectANoticeVO(int num) {
		String sql = "UPDATE viewnotice SET readcount = readcount + 1 WHERE num = ?";
		Object[] values = new Object[] {num};
		jdbcTemplate.update(sql, values);
		
		sql = "SELECT * FROM viewnotice WHERE num = ?";
		values = new Object[] {num};
		BoardVO boardVO = jdbcTemplate.queryForObject(sql, values, mapper);
		return boardVO;
	}


	public BoardVO selectOldBoardVO(int num) {
		String sql = "SELECT * FROM viewnotice WHERE num = ?";
		Object[] values = new Object[] {num};
		System.out.println("ffffff");
		BoardVO boardVO = jdbcTemplate.queryForObject(sql, values, mapper);
		
		return boardVO;
	}

	public void updateANotice(BoardVO boardVO) {
		String sql = "UPDATE viewnotice SET title = ?, content = ? , noticefile = ?"
				+ " WHERE num = ? ";
		System.out.println(boardVO.getContent() + " " + boardVO.getNum());
		Object[] values = new Object[] {
				boardVO.getTitle(), boardVO.getContent(), boardVO.getNoticefile(), boardVO.getNum()
		};
		jdbcTemplate.update(sql, values);
		
	}
	//게시글 여러개 삭제
	public void deleteANotice(int[] delete1) {
		String sql = "";
	      Object[] values = new Object[] {};
	      System.out.println(Arrays.toString(delete1));
	      for (int i = 0; i < delete1.length; i++) {
	              sql = "DELETE FROM viewnotice WHERE num = ?";
	              values = new Object[] {
	                delete1[i]
	          };
	              System.out.println("delete1[i]: "+delete1[i]);
	          jdbcTemplate.update(sql, values);
	       }
		
	}
	//게시글 내용 삭제
	public void deleteANoticeContent(int num) {
		String sql = "DELETE viewnotice WHERE num = ?";
		Object[] values = new Object[] {
				num
		};
		jdbcTemplate.update(sql, values);
	}
	
	public List<BoardVO> selectArticleList(int startRow, int pageSize) {
		String sql = "SELECT lwr.* FROM (SELECT ROWNUM rn, b.* FROM (SELECT * FROM viewnotice order by num desc) b) lwr WHERE rn between ? and ?";
		int endRow = startRow + pageSize - 1;
		System.out.println(startRow + " " + endRow);
		Object[] values = new Object[] {
				startRow, endRow
		};
		System.out.println("startRow:" + startRow + "/" + "endRow" + endRow);
		List<BoardVO> articleList = jdbcTemplate.query(sql, values, mapper);
		
		return articleList;
	}

}
