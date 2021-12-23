package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.UserDAO;
import vo.UserVO;

public class CheckOlIdService {

	public UserVO getCheckOlId(String id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		UserVO findId = userDAO.selectOlId(id);
		close(con);
		return findId;
	}

}
