package service;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;
import vo.UserVO;

public class DeleteUserService {

	public boolean deleteUserInfo(UserVO userVO) {
		// TODO Auto-generated method stub
		boolean deleteSuccess = false;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int deleteCount = userDAO.deleteUser(userVO);
		if(deleteCount > 0) {
			deleteSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		
		return deleteSuccess;
	}

}
