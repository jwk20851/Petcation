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
public class ManageReviewDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<BoardVO> mapper = new RowMapper<BoardVO>() {
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO boardVO = new BoardVO();
			
			boardVO.setNum(rs.getInt("num"));
			boardVO.setWriter(rs.getString("writer"));
			boardVO.setPetname(rs.getString("petname"));
			boardVO.setRate(rs.getInt("rate"));
			boardVO.setTitle(rs.getString("title"));
			boardVO.setContent(rs.getString("content"));
			boardVO.setReadcount(rs.getInt("readcount"));
			boardVO.setReg_date(rs.getTimestamp("reg_date"));
			
			return boardVO;
			}
		};

	public List<BoardVO> selectmanageReviewList() {
		String sql = "SELECT * FROM board1 ORDER BY num DESC";
		List<BoardVO> manageReviewList = jdbcTemplate.query(sql, mapper);
		return manageReviewList;
	}

	public void insertReview(BoardVO boardVO) {
		String sql = "INSERT INTO board1(num, content, rate, reg_date)"
				+ "VALUES(viewnotice_seq.nextval, ?, ?, sysdate)";
		
		
		Object[] values = new Object[] {
				boardVO.getContent(),
				boardVO.getRate()	
		};
		jdbcTemplate.update(sql, values);
		
	}

	public List<BoardVO> selectReviewWrittenList() {
		String sql = "SELECT * FROM board1 ORDER BY num DESC";
		List<BoardVO> manageWrittenReview = jdbcTemplate.query(sql, mapper);
		return manageWrittenReview;
	}

	public BoardVO selectOldBoardVO(int num) {
		String sql = "SELECT * FROM board1 WHERE num = ?";
		Object[] values = new Object[] {num};
		
		BoardVO boardVO = jdbcTemplate.queryForObject(sql, values, mapper);
		
		return boardVO;
	}

	public void updateANotice(BoardVO boardVO) {
		String sql = "UPDATE board1 SET rate = ?, content = ? "
				+ " WHERE num = ? ";
		Object[] values = new Object[] {
				boardVO.getRate(), boardVO.getContent(), boardVO.getNum()
		};
		jdbcTemplate.update(sql, values);
		
	}
	//삭제할 글 조회
	public BoardVO selectReviewDeleteVO(int num) {
		String sql = "SELECT * FROM board1 WHERE num = ?";
		Object[] values = new Object[] {num};
		BoardVO boardVO = jdbcTemplate.queryForObject(sql, values, mapper);
		return boardVO;
	}
	//삭제하기
	public void deleteReview(int num) {
		String sql = "DELETE board1 WHERE num = ?";
		Object[] values = new Object[] {
				num
		};
		jdbcTemplate.update(sql, values);
	}

	public List<BoardVO> selectArticleList(int startRow, int pageSize) {
		String sql = "SELECT lwr.* FROM (SELECT ROWNUM rn, b.* FROM (SELECT * FROM board1 order by num desc) b) lwr WHERE rn between ? and ?";
		
		int endRow = startRow + pageSize - 1;
		Object[] values = new Object[] {
				startRow, endRow
		};
		System.out.println("startRow:" + startRow + "/" + "endRow" + endRow);
		List<BoardVO> articleList = jdbcTemplate.query(sql, values, mapper);
		
		return articleList;
	}


}
