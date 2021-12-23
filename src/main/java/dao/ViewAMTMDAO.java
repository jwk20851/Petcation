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
public class ViewAMTMDAO {
	
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
	
	
	
	//조회
	public BoardVO selectAMTMVO(int num) {
		String sql = "SELECT * FROM viewmtm WHERE num = ?";
		Object[] values = new Object[] {num};
		BoardVO boardVO = jdbcTemplate.queryForObject(sql, values, mapper);
		return boardVO;
	}


	//list
	public List<BoardVO> selectAMTMList() {
		String sql = "SELECT * FROM viewmtm ORDER BY num DESC";
		List<BoardVO> viewAMTMList = jdbcTemplate.query(sql, mapper);
		return viewAMTMList;
	}

	//수정전 불러오기
	public BoardVO selectOldBoardVO(int num) {
		String sql = "SELECT * FROM viewmtm WHERE num = ?";
		Object[] values = new Object[] {num};
		BoardVO boardVO = jdbcTemplate.queryForObject(sql, values, mapper);
		
		return boardVO;
	}

	//수정후 저장하기
		public void updateAMTM(BoardVO boardVO) {
			String sql = "UPDATE viewmtm SET answer = ? WHERE num = ? ";
			System.out.println(boardVO.getAnswer());
			Object[] values = new Object[] {
					 boardVO.getAnswer(), boardVO.getNum()
			};
			jdbcTemplate.update(sql, values);
			
		}
		//삭제
		public void deleteMTM(int num) {
			String sql = "DELETE viewmtm WHERE num = ?";
			Object[] values = new Object[] {
					num
			};
			jdbcTemplate.update(sql, values);
			
		}

		//여러개 삭제
		public void deleteAMTM(int[] delete1) {
			String sql = "";
		      Object[] values = new Object[] {};
		      System.out.println(Arrays.toString(delete1));
		      for (int i = 0; i < delete1.length; i++) {
		              sql = "DELETE FROM viewmtm WHERE num = ?";
		              values = new Object[] {
		                delete1[i]
		          };
		              System.out.println("delete1[i]: "+delete1[i]);
		          jdbcTemplate.update(sql, values);
		       }
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
