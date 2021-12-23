package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vo.BoardVO;
import vo.FAQVO;

@Repository
public class FAQDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<FAQVO> mapper = new RowMapper<FAQVO>() {
		public FAQVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			FAQVO faqVO = new FAQVO();
			
			faqVO.setNum(rs.getInt("num"));
			faqVO.setWriter(rs.getString("writer"));
			faqVO.setContent(rs.getString("content"));
			faqVO.setReg_date(rs.getTimestamp("reg_date"));
			faqVO.setCheckbox(rs.getString("checkbox"));
			faqVO.setTitle(rs.getString("title"));
			faqVO.setNoticefile(rs.getString("noticefile"));
			faqVO.setAnswer(rs.getString("answer"));
			
			return faqVO;
			}
		};

	public List<FAQVO> selectFAQList() {
		String sql = "SELECT * FROM viewfaq ORDER BY num DESC";
		List<FAQVO> viewFAQList = jdbcTemplate.query(sql, mapper);
		return viewFAQList;
	}

	public List<FAQVO> selectArticleList(int startRow, int pageSize) {
String sql = "SELECT lwr.* FROM (SELECT ROWNUM rn, b.* FROM (SELECT * FROM viewfaq order by num desc) b) lwr WHERE rn between ? and ?";
		
		int endRow = startRow + pageSize - 1;
		Object[] values = new Object[] {
				startRow, endRow
		};
		System.out.println("startRow:" + startRow + "/" + "endRow" + endRow);
		List<FAQVO> articleList = jdbcTemplate.query(sql, values, mapper);
		
		return articleList;
	}

}
