package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;


import dao.UserDAO;
import vo.UserVO;

public class FindPwService {

	public boolean getFindPw(UserVO userVO) {
		// TODO Auto-generated method stub
		boolean updateSuccess = false;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int updateCount = userDAO.updatePw(userVO);
		if(updateCount > 0) {
			updateSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		
		return updateSuccess;
	}

	public UserVO getUserInfo(String id, String email) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		UserVO selectInfo = userDAO.selectUserInfo(id, email);
		close(con);
		return selectInfo;
	}

	
	
}
