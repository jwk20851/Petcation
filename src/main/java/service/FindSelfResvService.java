package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.HospResvDAO;
import vo.DateVO;
import vo.HospResvVO;
import vo.PetVO;

public class FindSelfResvService {

	public ArrayList<HospResvVO> getResvList(String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		ArrayList<HospResvVO> findselfResv = hospResvDAO.selectselfResv(user_id);
		close(con);
		return findselfResv;
	}

	public ArrayList<PetVO> getResvPetList(String user_id, ArrayList<HospResvVO> findresv) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		ArrayList<PetVO> findselfResv = hospResvDAO.selectResvPet(user_id, findresv);
		close(con);
		return findselfResv;
	}

	public ArrayList<DateVO> getResvDateList(String user_id, ArrayList<HospResvVO> findresv) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		ArrayList<DateVO> findselfResv = hospResvDAO.selectResvDate(user_id, findresv);
		close(con);
		return findselfResv;
	}

}
