package service;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.HospResvDAO;


public class CancelResvService {

	public boolean getcancelResv(String[] tp, String[] timearr) {
		// TODO Auto-generated method stub
		boolean updateSuccess = false;
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		int updateCount = hospResvDAO.updateResv(tp, timearr);
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
