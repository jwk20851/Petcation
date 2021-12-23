package service;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;
import vo.UserVO;

public class UpdateUserService {

	public boolean getupdateUser(UserVO userVO) {
		// TODO Auto-generated method stub
		boolean updateSuccess = false;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int updateCount = userDAO.updateUser(userVO);
		if(updateCount > 0) {
			updateSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		
		return updateSuccess;
	}

	

}
