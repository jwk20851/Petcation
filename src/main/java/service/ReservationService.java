package service;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.HospDAO;
import vo.HospResvVO;

public class ReservationService {

	public boolean setReservation(HospResvVO hospResvVO, String user_id, int tt, String time, String date) {
		// TODO Auto-generated method stub
		boolean updateSuccess = false;
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		int updateCount = hospDAO.insertReservation(hospResvVO, user_id, tt, time, date);
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
