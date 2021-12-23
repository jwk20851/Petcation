package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.UserDAO;
import vo.UserVO;

public class CheckPwService {

	public UserVO exitCheckPw(String pw, String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		UserVO checkpw = userDAO.selectchPw(pw, user_id);
		close(con);
		return checkpw;
	}

}

