package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.HospDAO;
import dao.UserDAO;
import vo.HospVO;

public class SysUpdateService {

	public boolean updateSys(HospVO hospVO, String user_id) {
		// TODO Auto-generated method stub
		boolean updateSuccess = false;
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		int insertCount = hospDAO.updateSys(hospVO,user_id);
		if(insertCount > 0) {
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
