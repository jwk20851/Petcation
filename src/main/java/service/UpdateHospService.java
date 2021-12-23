package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.HospDAO;
import dao.UserDAO;
import vo.DateVO;
import vo.HospResvVO;
import vo.HospVO;

public class UpdateHospService {

	public boolean getupdateHosp(HospVO hospVO, String user_id) {
		// TODO Auto-generated method stub
		boolean updateSuccess = false;
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		int updateCount = hospDAO.updateHosp(hospVO, user_id);
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

	public HospVO getfindHosp(String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		HospVO findHospVO = hospDAO.selectUpdatedHosp(user_id);
		close(con);
		return findHospVO;
	}

	public boolean getinsertHosp(int tprimary, String hosname, HospResvVO hospResvVO, String user_id) {
		// TODO Auto-generated method stub
		boolean insertSuccess = false;
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		int insertCount = hospDAO.insertUser(tprimary, hosname, hospResvVO, user_id);
		if(insertCount > 0) {
			insertSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		close(con);

		return insertSuccess;
	}

	public boolean getinsertDate(int dnum) {
		// TODO Auto-generated method stub
		boolean insertSuccess = false;
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		int insertCount = hospDAO.insertResvDate(dnum);
		if(insertCount > 0) {
			insertSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		close(con);

		return insertSuccess;
	}

	public DateVO getfindResvDate(int dnum) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);

		DateVO findDateVO = hospDAO.selectResvDate(dnum);
		close(con);
		return findDateVO;
	}

}
