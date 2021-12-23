package service;

import static db.JdbcUtil.*;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.HospDAO;

public class CancelStopService {

	public boolean updatestop(String user_id) {
		// TODO Auto-generated method stub
		boolean updateSuccess = false;
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		int updateCount = hospDAO.updateStop(user_id);
		if(updateCount > 0) {
			updateSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		
		close(con);
		return updateSuccess;
	}

}
