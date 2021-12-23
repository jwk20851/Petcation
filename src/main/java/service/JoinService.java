package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;
import vo.UserVO;

public class JoinService {

	public boolean joinUser(UserVO userVO) {
		// TODO Auto-generated method stub
		boolean registSuccess = false;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int insertCount = userDAO.insertUser(userVO);
		if(insertCount > 0) {
			registSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		close(con);
		return registSuccess;
	}

}
