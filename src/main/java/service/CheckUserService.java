package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.UserDAO;
import vo.UserVO;

public class CheckUserService {

	public UserVO getUserInfo(String name, String id, String pw) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		UserVO checkUser = userDAO.selectUserInfo(name, id, pw);
		close(con);
		return checkUser;
	}

}
