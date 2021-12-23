package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.HospDAO;
import vo.HospResvVO;
import vo.HospVO;

public class SearchHosResvService {

	public ArrayList<HospResvVO> getFindHosresv(int tt, String date) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		ArrayList<HospResvVO> findHosResv = hospDAO.selectHospResvInfo(tt, date);
		close(con);
		return findHosResv;
	}

}
