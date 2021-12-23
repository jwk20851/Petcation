package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import dao.HospResvDAO;
import vo.DateVO;
import vo.HospResvVO;
import vo.HospVO;
import vo.UserVO;


public class ResvListService {

	public int getArticleCount(String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		int articleCount = hospResvDAO.selectArticleCount(user_id);
		close(con);
		return articleCount;
	}

	public List<HospResvVO> getResvList(int startRow, int pageSize, String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		List<HospResvVO> findResvList = hospResvDAO.selectResvList(startRow, pageSize, user_id);
		close(con);
		return findResvList;
	}

	public List<DateVO> getResvDateList(int startRow, int pageSize, String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		List<DateVO> findResvDateList = hospResvDAO.selectResvDateList(startRow, pageSize, user_id);
		close(con);
		return findResvDateList;
	}

	public List<UserVO> getResvName(int startRow, int pageSize, String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		List<UserVO> findResvNameList = hospResvDAO.selectResvNameList(startRow, pageSize, user_id);
		close(con);
		return findResvNameList;
	}

	public List<HospVO> getResvHosTel(int startRow, int pageSize, String user_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		HospResvDAO hospResvDAO = HospResvDAO.getInstance();
		hospResvDAO.setConnection(con);
		
		List<HospVO> findResvHosList = hospResvDAO.selectResvHosList(startRow, pageSize, user_id);
		close(con);
		return findResvHosList;
	}

}
