package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vo.BoardVO;
import vo.ReserveVO;
@Repository
public class HosReviewDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<ReserveVO> mapper = new RowMapper<ReserveVO>() {
	public ReserveVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReserveVO reserveVO = new ReserveVO();
		
		reserveVO.setNum(rs.getInt("num"));
		reserveVO.setContent(rs.getString("content"));
		reserveVO.setRate(rs.getInt("rate"));
		reserveVO.setId(rs.getString("id"));
		reserveVO.setWritedate(rs.getString("writedate"));

		return reserveVO;
		}
	};

	public List<ReserveVO> selectHosReviewList() {
String sql = "SELECT * FROM hosreview";
		
		List<ReserveVO> viewHosReviewList = jdbcTemplate.query(sql, mapper);

		return viewHosReviewList;
	}

	public List<ReserveVO> selectArticleList(int startRow, int pageSize) {
		String sql = "SELECT lwr.* FROM (SELECT ROWNUM rn, b.* FROM (SELECT * FROM hosreview order by num desc) b) lwr WHERE rn between ? and ?";
		
		int endRow = startRow + pageSize - 1;
		Object[] values = new Object[] {
				startRow, endRow
		};
		System.out.println("startRow:" + startRow + "/" + "endRow" + endRow);
		List<ReserveVO> articleList = jdbcTemplate.query(sql, values, mapper);
		
		return articleList;
	}

}
