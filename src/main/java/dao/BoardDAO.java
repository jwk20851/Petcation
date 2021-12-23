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


//DAO(Data Access Object) : DBMS�� SQL ������ �����ϴ� Ŭ����
@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Connection con;
	//singleton ����
	
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

	public int insertArticle(BoardVO boardVO) throws Exception{	//���� ���Ե� ���� ������.
		int insertCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//�亯��ó���� �ʿ��� ����
		int num = boardVO.getNum();
		
		int number = 0;
		//�ۼ��� ���� �����϶� ���� �ο��� ���ñ� ��ȣ�� ������ ����
		String sql = "";
		try {
			 pstmt = con.prepareStatement("SELECT MAX(num) FROM board1");
	         rs = pstmt.executeQuery();
			//���� �ۼ��� ���� ������ �ִ밪�� ���ڵ尡 ����.
			if(rs.next()) {	//���ݱ��� �ۼ��� ���� �ϳ��� ������...
				number = rs.getInt(1) + 1;	//�ִ밪�� +1 �ߺ����� �ʰ� �ϱ� ����

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
		
		return insertCount;	//service�� �Ѿ
	}

	public int selectArticleCount() throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int articleCount = 0;
		try {				//DB�۾��Ҷ� ����ó�� �ؾ���.
			 pstmt = con.prepareStatement("SELECT COUNT(*) FROM board1");			//6.����� action���� �̵�
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return articleCount;
	}

	public List<BoardVO> selectArticleList(int startRow, int pageSize) throws Exception{		//9.�ۼ�
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;
		try {				//DB�۾��Ҷ� ����ó�� �ؾ���.
			//�ش� �������� ��µ� �۵鸸 ��ȸ�ؾ� ��
			pstmt = con.prepareStatement(""					//list�� �ٽ�������.
					+ "SELECT list2.* FROM (SELECT ROWNUM r, board1.* "		//ROWNUM : ��ȸ�Ǵ� ������� ���ڵ� ������.
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
			close(pstmt);				//9.�ۼ��� action�� ������ �ٷ� �̵��Ͽ� ������ �ۼ��ϱ�.
		}
		return articleList;		//service �� ����
	}

	public BoardVO selectArticle(int num) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		try {				//DB�۾��Ҷ� ����ó�� �ؾ���.
			//��ȸ�� ���� �۾�
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

	public BoardVO selectUpdateArticle(int num) throws Exception{	//��(selectArticle)���� �ٸ��� ��ȸ�� ����x
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		try {				//DB�۾��Ҷ� ����ó�� �ؾ���.
			
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
		//���� ����ڰ� �Է��� ��й�ȣ�� ���� ��������� �Է��� ��ȣ�� ������
		//�����۾��� ����
		//��й�ȣ�� Ʋ���� �ۼ��� ���� �ƴ϶�� �Ǵ��ϰ� ����ó��.
		
		int updateCount = 0;
		PreparedStatement pstmt = null;		//sql�۾��� ����
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
		return updateCount;	//service�� �Ѿ
	}

	public int deleteArticle(int num) {
		
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			
	         System.out.println("num = " + num);
	         
				//�ش� �� ��ȣ�� ������ �ִ� ���� ������
				
					sql = "DELETE FROM board1 WHERE num = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					deleteCount = pstmt.executeUpdate();	
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}

		return deleteCount; // service�� �Ѿ
	}

public void deleteBoard(int num) {
	String sql = "DELETE FROM board1 WHERE num = ?";
	Object[] values = new Object[] {
			num
	};
	jdbcTemplate.update(sql,values);
	
}
}
