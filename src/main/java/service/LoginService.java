package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.UserDAO;
import vo.UserVO;

public class LoginService {

	public UserVO getLoginUser(String id, String passwd) {
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		UserVO loginUser = userDAO.selectLoginUser(id, passwd);
		close(con);
		return loginUser;
	}

}
