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
public class ViewMTMDAO {
	
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
			boardVO.setAnswer(rs.getString("answer"));
			boardVO.setWriter(rs.getString("writer"));
			boardVO.setReg_date(rs.getTimestamp("reg_date"));
			
			return boardVO;
			}
		};
		
		//글쓰기
	public void insertANotice(BoardVO boardVO) {
		String sql = "INSERT INTO viewmtm(num, title, content, answer, noticefile, reg_date)"
				+ "VALUES(viewmtm_seq.nextval, ?, ?, ?, ?, sysdate)";
		
		Object[] values = new Object[] {
				boardVO.getTitle(),
				boardVO.getContent(),
				boardVO.getAnswer(),
				boardVO.getNoticefile()
		};
		
		jdbcTemplate.update(sql, values);
		
	}
	//list
	public List<BoardVO> selectViewMTMList() {
		String sql = "SELECT * FROM viewmtm ORDER BY num DESC";
		List<BoardVO> viewAMTMList = jdbcTemplate.query(sql, mapper);
		return viewAMTMList;
	}
	//조회
	public BoardVO selectMTMVO(int num) {	
		String sql = "SELECT * FROM viewmtm WHERE num = ?";
		Object[] values = new Object[] {num};
		BoardVO boardVO = jdbcTemplate.queryForObject(sql, values, mapper);
		return boardVO;
	}
	//삭제
	public void deleteMTM(int num) {
		String sql = "DELETE viewmtm WHERE num = ?";
		Object[] values = new Object[] {
				num
		};
		jdbcTemplate.update(sql, values);
		
	}
	public List<BoardVO> selectArticleList(int startRow, int pageSize) {
		String sql = "SELECT lwr.* FROM (SELECT ROWNUM rn, b.* FROM (SELECT * FROM viewmtm order by num desc) b) lwr WHERE rn between ? and ?";
		
		int endRow = startRow + pageSize - 1;
		Object[] values = new Object[] {
				startRow, endRow
		};
		System.out.println("startRow:" + startRow + "/" + "endRow" + endRow);
		List<BoardVO> articleList = jdbcTemplate.query(sql, values, mapper);
		
		return articleList;
	}

}
