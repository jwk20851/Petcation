package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.UserDAO;
import vo.UserVO;

public class FindIdService {

	public UserVO getFindId(String name, String email) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		UserVO findId = userDAO.selectId(name, email);
		close(con);
		return findId;
	}

}
