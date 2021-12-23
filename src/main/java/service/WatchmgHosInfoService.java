package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.HospDAO;
import vo.HospVO;


public class WatchmgHosInfoService {

	public HospVO findmgHosInfo(String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospDAO hospDAO = HospDAO.getInstance();
		hospDAO.setConnection(con);
		
		HospVO findHos = hospDAO.selectMgHosInfo(user_id);
		close(con);
		return findHos;
	}

}
