package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.PetDAO;
import vo.PetVO;

public class SearchPetService {

	public ArrayList<PetVO> getFindPet(String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PetDAO petDAO = PetDAO.getInstance();
		petDAO.setConnection(con);
		
		ArrayList<PetVO> findpet = petDAO.selectPetinfo(user_id);
		close(con);
		return findpet;
	}

}
