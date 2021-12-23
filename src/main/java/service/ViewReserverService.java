package service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.HospResvDAO;
import vo.DateVO;
import vo.HospResvVO;
import vo.PetVO;
import vo.UserVO;

public class ViewReserverService {

	public PetVO getResverInfo(HospResvVO hospResvVO, DateVO dateVO, UserVO userVO) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		PetVO findResverInfo = hospResvDAO.selectResverInfo(hospResvVO, dateVO, userVO);
		close(con);
		return findResverInfo;
	}

}
