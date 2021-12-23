package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vo.BoardVO;

import static db.JdbcUtil.*;


//DAO(Data Access Object) : DBMS로 SQL 구문을 전송하는 클래스
@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Connection con;
	//singleton 패턴
	
	private static BoardDAO instance;
	
	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;	
	}

	public int insertArticle(BoardVO boardVO) throws Exception{	//글이 삽입된 갯수 리턴함.
		int insertCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//답변글처리에 필요한 값들
		int num = boardVO.getNum();
		
		int number = 0;
		//작성한 글이 원글일때 새로 부여할 관련글 번호를 저장할 변수
		String sql = "";
		try {
			 pstmt = con.prepareStatement("SELECT MAX(num) FROM board1");
	         rs = pstmt.executeQuery();
			//현재 작성된 글이 없으면 최대값은 레코드가 없다.
			if(rs.next()) {	//지금까지 작성된 글이 하나라도 있으면...
				number = rs.getInt(1) + 1;	//최대값에 +1 중복되지 않게 하기 위해

			}
			else {
				number = 1;
			}
			
			 sql = "INSERT INTO board1(num, rate, content, reg_date)" +
		               " VALUES(board1_seq.nextval, ?, ?, ?)";
			 pstmt = con.prepareStatement(sql);
			 
//			 pstmt.setString(1, boardVO.getName());
			 
	         pstmt.setInt(1, boardVO.getRate());
	         pstmt.setString(2, boardVO.getContent());
	         pstmt.setTimestamp(3, boardVO.getReg_date());
	         
	         System.out.println(boardVO.getRate());
	         System.out.println(boardVO.getContent());
	         
	         insertCount = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;	//service로 넘어감
	}

	public int selectArticleCount() throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int articleCount = 0;
		try {				//DB작업할땐 예외처리 해야함.
			 pstmt = con.prepareStatement("SELECT COUNT(*) FROM board1");			//6.만들고 action으로 이동
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return articleCount;
	}

	public List<BoardVO> selectArticleList(int startRow, int pageSize) throws Exception{		//9.작성
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;
		try {				//DB작업할땐 예외처리 해야함.
			//해당 페이지에 출력될 글들만 조회해야 함
			pstmt = con.prepareStatement(""					//list의 핵심쿼리임.
					+ "SELECT list2.* FROM (SELECT ROWNUM r, board1.* "		//ROWNUM : 조회되는 순서대로 레코드 가져옴.
					+ " FROM board1)"
					+ " list2 WHERE r BETWEEN ? AND ?");
			

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, startRow + pageSize - 1);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardVO>();
				do {
					BoardVO boardVO = new BoardVO();
					boardVO.setContent(rs.getString("content"));
					boardVO.setNum(rs.getInt("num"));
					boardVO.setWriter(rs.getString("writer"));
					boardVO.setTitle(rs.getString("title"));
					boardVO.setReg_date(rs.getTimestamp("reg_date"));
					boardVO.setReadcount(rs.getInt("readcount"));
					boardVO.setContent(rs.getString("content"));
					boardVO.setReg_date(rs.getTimestamp("reg_date"));
					
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);				//9.작성후 action의 마지막 줄로 이동하여 나머지 작성하기.
		}
		return articleList;		//service 로 리턴
	}

	public BoardVO selectArticle(int num) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		try {				//DB작업할땐 예외처리 해야함.
			//조회수 증가 작업
			pstmt = con.prepareStatement(""	
					+ "UPDATE board1 SET readcount = readcount + 1 WHERE num = ?");			
			pstmt.setInt(1, num);
			int updateCount = pstmt.executeUpdate();
			if(updateCount > 0) {
				commit(con);
			}
			else {
				rollback(con);
			}
			
			pstmt = con.prepareStatement(""	
					+ "SELECT * FROM board1 WHERE num = ?");	
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				article = new BoardVO();
					article.setContent(rs.getString("content"));
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setTitle(rs.getString("title"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setContent(rs.getString("content"));
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);				
		}
		
		return article;
	}

	public BoardVO selectUpdateArticle(int num) throws Exception{	//위(selectArticle)에랑 다른건 조회수 증가x
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		try {				//DB작업할땐 예외처리 해야함.
			
			pstmt = con.prepareStatement(""	
					+ "SELECT * FROM board1 WHERE num = ?");	
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				article = new BoardVO();
					article.setContent(rs.getString("content"));
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setTitle(rs.getString("title"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setContent(rs.getString("content"));
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);				
		}
		
		return article;
	}

	public int updateArticle(BoardVO boardVO) throws Exception{
		//먼저 사용자가 입력한 비밀번호가 글을 등록했을때 입력한 번호와 같으면
		//수정작업을 실행
		//비밀번호가 틀리면 작성한 글이 아니라고 판단하고 실패처리.
		
		int updateCount = 0;
		PreparedStatement pstmt = null;		//sql작업시 선언
		String sql = "";

		
		try {

					sql = "UPDATE board1 SET content = ? , rate = ?"
							 + " WHERE num = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, boardVO.getContent());
					pstmt.setInt(2, boardVO.getRate());
					pstmt.setInt(3, boardVO.getNum());
					updateCount = pstmt.executeUpdate();	
					
					 System.out.println(boardVO.getRate());
			         System.out.println(boardVO.getContent());
				
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {

			close(pstmt);
		}
		return updateCount;	//service로 넘어감
	}

	public int deleteArticle(int num) {
		
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			
	         System.out.println("num = " + num);
	         
				//해당 글 번호를 가지고 있는 글이 있으면
				
					sql = "DELETE FROM board1 WHERE num = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					deleteCount = pstmt.executeUpdate();	
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}

		return deleteCount; // service로 넘어감
	}

public void deleteBoard(int num) {
	String sql = "DELETE FROM board1 WHERE num = ?";
	Object[] values = new Object[] {
			num
	};
	jdbcTemplate.update(sql,values);
	
}
}
