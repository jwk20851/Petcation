package service;
import static db.JdbcUtil.*;		//3.작성후 action 으로 이동

import java.sql.Connection;
import java.util.List;

import dao.BoardDAO;
import vo.BoardVO;

public class BoardListService {

	public int getArticleCount() throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int articleCount = boardDAO.selectArticleCount();		//5. 작성후 DAO로 이동
		close(con);
		return articleCount;
	}

	public List<BoardVO> getArticleList(int startRow, int pageSize) throws Exception{
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		List<BoardVO> articleList = boardDAO.selectArticleList(startRow, pageSize);		//8. selectArticleList 만들러 BoardDAO로 이동
		close(con);
		
		return articleList;			//action으로 리턴
	}

}
