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
import vo.FAQVO;

@Repository
public class AFAQDAO {
	
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
	//list
	public List<FAQVO> selectAFAQList() {
		String sql = "SELECT * FROM viewfaq ORDER BY num DESC";
		List<FAQVO> viewAFAQList = jdbcTemplate.query(sql, mapper);
		return viewAFAQList;
	}

	public void insertAFAQ(FAQVO faqVO) {
		String sql = "INSERT INTO viewfaq(num, title, content, noticefile, reg_date)"
				+ "VALUES(viewfaq_seq.nextval, ?, ?, ?, sysdate)";
		
		Object[] values = new Object[] {
				faqVO.getTitle(),
				faqVO.getContent(),
				faqVO.getNoticefile()	
		};
		
		jdbcTemplate.update(sql, values);
		
	}
	//게시글 여러개 삭제
	public void deleteAFAQ(int[] delete1) {
		String sql = "";
	      Object[] values = new Object[] {};
	      System.out.println(Arrays.toString(delete1));
	      for (int i = 0; i < delete1.length; i++) {
	              sql = "DELETE FROM viewfaq WHERE num = ?";
	              values = new Object[] {
	                delete1[i]
	          };
	              System.out.println("delete1[i]: "+delete1[i]);
	          jdbcTemplate.update(sql, values);
	       }
	}
	//수정전 정보 불러오기
	public FAQVO selectOldFAQVO(int num) {
		String sql = "SELECT * FROM viewfaq WHERE num = ?";
		Object[] values = new Object[] {num};
		
		FAQVO faqVO = jdbcTemplate.queryForObject(sql, values, mapper);
		
		return faqVO;
	}
	//수정후 정보저장
	public void updateAFAQ(FAQVO faqVO) {
		String sql = "UPDATE viewfaq SET title = ?, content = ?"
				+ " WHERE num = ? ";
		Object[] values = new Object[] {
				faqVO.getTitle(), faqVO.getContent(), faqVO.getNum()
		};
		jdbcTemplate.update(sql, values);
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
