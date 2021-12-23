package service;
import static db.JdbcUtil.*;		//3.�ۼ��� action ���� �̵�

import java.sql.Connection;
import java.util.List;

import dao.BoardDAO;
import vo.BoardVO;

public class BoardListService {

	public int getArticleCount() throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int articleCount = boardDAO.selectArticleCount();		//5. �ۼ��� DAO�� �̵�
		close(con);
		return articleCount;
	}

	public List<BoardVO> getArticleList(int startRow, int pageSize) throws Exception{
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		List<BoardVO> articleList = boardDAO.selectArticleList(startRow, pageSize);		//8. selectArticleList ���鷯 BoardDAO�� �̵�
		close(con);
		
		return articleList;			//action���� ����
	}

}
