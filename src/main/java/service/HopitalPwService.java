package service;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.UserDAO;
import vo.UserVO;

public class HopitalPwService {

	public UserVO findHospPw(String passWord) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);

		UserVO HospPw = userDAO.selectHospPw(passWord);
		close(con);
		return HospPw;
	}
}
