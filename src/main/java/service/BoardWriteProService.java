package service;

import vo.BoardVO;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
public class BoardWriteProService {

	public boolean registArticle(BoardVO boardVO) throws Exception{
		boolean registSuccess = false;
		Connection con = getConnection();			//자주 쓰이는 구문.
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int insertCount = boardDAO.insertArticle(boardVO);
		if(insertCount > 0) {
			registSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		
		return registSuccess;	//action으로 넘어감.
	}

}
