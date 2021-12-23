package service;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDAO;
import vo.BoardVO;

@Service
public class BoardDeleteProService {

	public boolean deleteArticle(int num) throws Exception{
		boolean deleteSuccess = false;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int deleteCount = boardDAO.deleteArticle(num);
		System.out.println(deleteCount);
		if(deleteCount > 0) {
			commit(con);
			deleteSuccess = true;
		}
		else {
			rollback(con);
		}

		return deleteSuccess;
	}

	@Autowired
	private BoardDAO boardDAO;
	
	public void removeBoard(int num) {
		boardDAO.deleteBoard(num);
		
	}

}
