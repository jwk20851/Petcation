package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.HospResvDAO;

public class FinishTreatService {

	public boolean getFinTreat(int tprimary, String user_id, String username, String rdate, String rt, String petname, String petInfodetail) {
		// TODO Auto-generated method stub
		boolean updateSuccess = false;
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		int updateCount = hospResvDAO.updatefinTreat(tprimary, user_id, username, rdate, rt, petname, petInfodetail);
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
