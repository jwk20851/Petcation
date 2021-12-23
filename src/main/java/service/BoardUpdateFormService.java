package service;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardVO;
public class BoardUpdateFormService {

	public BoardVO getUpdateArticle(int num) throws Exception{
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		BoardVO article = boardDAO.selectUpdateArticle(num);//�ش� �������� ������ �ִ� �� select�Ѵ�.
		close(con);
		
		return article;
	}
}
