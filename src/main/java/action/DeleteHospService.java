package action;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.HospDAO;



public class DeleteHospService {

	public boolean deleteHospInfo(String user_id) {
		// TODO Auto-generated method stub
		boolean deleteSuccess = false;
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		int deleteCount = hospDAO.deleteHosp(user_id);
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
