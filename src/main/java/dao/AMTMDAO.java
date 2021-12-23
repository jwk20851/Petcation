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
public class AMTMDAO {

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
			boardVO.setWriter(rs.getString("writer"));
			boardVO.setAnswer(rs.getString("answer"));
			boardVO.setReg_date(rs.getTimestamp("reg_date"));
			
			return boardVO;
			}
		};

	public List<BoardVO> selectAMTMList() {
		String sql = "SELECT * FROM viewamtm ORDER BY num DESC";
		List<BoardVO> viewAMTMList = jdbcTemplate.query(sql, mapper);
		return viewAMTMList;
	}
}
