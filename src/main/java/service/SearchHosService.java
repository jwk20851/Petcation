package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.HospDAO;
import vo.HospResvVO;
import vo.HospVO;


public class SearchHosService {

	public ArrayList<HospVO> getFindHos(String searchHos) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		ArrayList<HospVO> findHos = hospDAO.selectHospInfo(searchHos);
		close(con);
		return findHos;
	}

	

}
