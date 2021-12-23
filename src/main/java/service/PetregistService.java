package service;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.PetDAO;
import vo.PetVO;

public class PetregistService {

	public boolean registPet(PetVO petVO) {
		// TODO Auto-generated method stub
		boolean registSuccess = false;
		Connection con = getConnection();
		PetDAO petDAO = PetDAO.getInstance();
		petDAO.setConnection(con);

		int insertCount = petDAO.insertPet(petVO);
		if (insertCount > 0) {
			registSuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		return registSuccess;
	}

}
