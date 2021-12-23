package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vo.DateVO;
import vo.HospResvVO;
import vo.HospVO;

public class HospDAO {
	private static Connection con;
	//singleton 패턴
	
	private static HospDAO instance;
	
	private HospDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static HospDAO getInstance() {
		if(instance == null) {
			instance = new HospDAO();
		}
		
		return instance;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
		
	}

	public int updateSys(HospVO hospVO, String user_id) {
		// TODO Auto-generated method stub
		int insertCount = 0;
		PreparedStatement pstmt = null;


		try {
			String sql = "insert into hosinfo(Hosp_name, Hosp_tel, Hosp_time, Hosp_address1, Hosp_address2, Hosp_stop, Hosp_reason, user_id, d_num) "
		               + "select ?, ?, ?, ?, ? ,?, ?, ?, h_seq.nextval from dual "
		               + "where not exists (select user_id from hosinfo where user_id = ? and (Hosp_tel = ? OR Hosp_address1 = ? OR Hosp_address2 = ?))";         

		            pstmt = con.prepareStatement(sql);
		            pstmt.setString(1, hospVO.getHosp_name());
					pstmt.setString(2, hospVO.getHosp_tel());
					pstmt.setString(3, hospVO.getHosp_time());
					pstmt.setString(4, hospVO.getHosp_address1());
					pstmt.setString(5, hospVO.getHosp_address2());
					pstmt.setString(6, hospVO.getHosp_stop());
					pstmt.setString(7, hospVO.getHosp_reason());
					pstmt.setString(8, "sct1234A");
					pstmt.setString(9, user_id);
					pstmt.setString(10, hospVO.getHosp_tel());
					pstmt.setString(11, hospVO.getHosp_address1());
					pstmt.setString(12, hospVO.getHosp_address2());

		            insertCount = pstmt.executeUpdate();
		            
		            if(insertCount <= 0) {
			               sql = "update hosinfo set Hosp_tel = ?, Hosp_time = ?, Hosp_address1 = ? ,Hosp_address2 = ?, Hosp_stop = ?, Hosp_reason = ?, user_id = ? "
			               		+ "where Hosp_name = ? and (Hosp_tel = ? or Hosp_address1 = ? or Hosp_address2 = ?)";         
			               pstmt = con.prepareStatement(sql);
							pstmt.setString(1, hospVO.getHosp_tel());
							pstmt.setString(2, hospVO.getHosp_time());
							pstmt.setString(3, hospVO.getHosp_address1());
							pstmt.setString(4, hospVO.getHosp_address2());
							pstmt.setString(5, hospVO.getHosp_stop());
							pstmt.setString(6, hospVO.getHosp_reason());
							pstmt.setString(7, user_id);
				            pstmt.setString(8, hospVO.getHosp_name());
				            pstmt.setString(9, hospVO.getHosp_tel());
							pstmt.setString(10, hospVO.getHosp_address1());
							pstmt.setString(11, hospVO.getHosp_address2());
			               insertCount = pstmt.executeUpdate();
			            }
		            
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return insertCount;
	}

	public int updateHosp(HospVO hospVO, String user_id) {
		// TODO Auto-generated method stub
		int insertCount = 0;
		PreparedStatement pstmt = null;


		try {
			String sql = "insert into hosinfo(Hosp_name, Hosp_tel, Hosp_time, Hosp_address2, Hosp_stop, Hosp_reason, user_id, d_num) "
		               + "select ?, ?, ?, ?, ?, ?, ?, h_seq.nextval from dual "
		               + "where not exists (select user_id from hosinfo where (user_id = ? or user_id = ?) and (Hosp_tel = ? OR Hosp_address1 = ? OR Hosp_address2 = ?))";         

		            pstmt = con.prepareStatement(sql);
		            pstmt.setString(1, hospVO.getHosp_name());
					pstmt.setString(2, hospVO.getHosp_tel());
					pstmt.setString(3, hospVO.getHosp_time());
					pstmt.setString(4, hospVO.getHosp_address2());
					pstmt.setString(5, hospVO.getHosp_stop());
					pstmt.setString(6, hospVO.getHosp_reason());
					pstmt.setString(7, user_id);
					pstmt.setString(8, user_id);
					pstmt.setString(9, "sct1234A");
					pstmt.setString(10, hospVO.getHosp_tel());
					pstmt.setString(11, hospVO.getHosp_address2());
					pstmt.setString(12, hospVO.getHosp_address2());

		            insertCount = pstmt.executeUpdate();
		            
		            if(insertCount <= 0) {
		               sql = "update hosinfo set Hosp_tel = ?, Hosp_time = ?, Hosp_address2 = ?, Hosp_stop = ?, Hosp_reason = ?, user_id = ? "
		               		+ "where (user_id = ? or user_id = ?) and (Hosp_tel = ? OR Hosp_address1 = ? OR Hosp_address2 = ?)";         
		               pstmt = con.prepareStatement(sql);
						pstmt.setString(1, hospVO.getHosp_tel());
						pstmt.setString(2, hospVO.getHosp_time());
						pstmt.setString(3, hospVO.getHosp_address2());
						pstmt.setString(4, hospVO.getHosp_stop());
						pstmt.setString(5, hospVO.getHosp_reason());
						pstmt.setString(6, user_id);
						pstmt.setString(7, "sct1234A");
						pstmt.setString(8, user_id);
						pstmt.setString(9, hospVO.getHosp_tel());
						pstmt.setString(10, hospVO.getHosp_address2());
						pstmt.setString(11, hospVO.getHosp_address2());


		               insertCount = pstmt.executeUpdate();
		            }
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return insertCount;
	}

	public HospVO selectUpdatedHosp(String user_id) {
		// TODO Auto-generated method stub
		HospVO hospVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from hosinfo where user_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				hospVO = new HospVO();
				hospVO.setHosp_name(rs.getString("Hosp_name"));
				hospVO.setHosp_tel(rs.getString("Hosp_tel"));
				hospVO.setHosp_time(rs.getString("Hosp_time"));
				hospVO.setHosp_address2(rs.getString("Hosp_address2"));
				hospVO.setHosp_stop(rs.getString("Hosp_stop"));
				hospVO.setHosp_reason(rs.getString("Hosp_reason"));
				hospVO.setDnum(rs.getInt("d_num"));
			}
		
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return hospVO;
	}

	public int deleteHosp(String user_id) {
		// TODO Auto-generated method stub
		int deleteCount = 0;
		PreparedStatement pstmt = null;



		String sql = "delete from hosinfo where user_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			deleteCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return deleteCount;
	}

//	public int insertUser(HospVO hospVO, HospResvVO hospResvVO, String user_id) {
//		// TODO Auto-generated method stub
//		int insertCount = 0;
//		PreparedStatement pstmt = null;
//
//		try {
//			String sql = null;
//			
//			sql = "DELETE FROM hospresvtime "
//					+ "WHERE tprimary IN (SELECT tprimary FROM hosinfo)";
//			pstmt = con.prepareStatement(sql);
//			insertCount = pstmt.executeUpdate();
//
//			for(int i = 0; i < hospResvVO.getResv_time().length; i++) {
//				
//				sql = "insert into hospresvtime(tprimary, time_num, resv_time) "
//						+ "select h.tprimary, ?, ? from HOSINFO h "
//						+ "where h.tprimary = tprimary";
//				
//				
//				pstmt = con.prepareStatement(sql);
//				pstmt.setInt(1, i);
//				pstmt.setString(2, hospResvVO.getResv_time()[i]);
//				
//				insertCount = pstmt.executeUpdate();
//
//			}
//			
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		finally {
//			close(pstmt);
//		}
//		return insertCount;
//	}

	public ArrayList<HospVO> selectHospInfo(String searchHos) {
		// TODO Auto-generated method stub
		ArrayList<HospVO> hospVOList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from hosinfo where Hosp_name like ? or Hosp_address1 like ? or Hosp_address2 like ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchHos+"%");
			pstmt.setString(2, "%"+searchHos+"%");
			pstmt.setString(3, "%"+searchHos+"%");
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				hospVOList = new ArrayList<HospVO>();
				HospVO hospVO = null;
				do {
					hospVO = new HospVO();
					hospVO.setHosp_name(rs.getString("Hosp_name"));
					hospVO.setHosp_tel(rs.getString("Hosp_tel"));
					hospVO.setHosp_time(rs.getString("Hosp_time"));
					hospVO.setHosp_address1(rs.getString("Hosp_address1"));
					hospVO.setHosp_address2(rs.getString("Hosp_address2"));
					hospVO.setHosp_stop(rs.getString("Hosp_stop"));
					hospVO.setHosp_reason(rs.getString("Hosp_reason"));
					hospVO.setDnum(rs.getInt("d_num"));
					hospVOList.add(hospVO);
				}
				while(rs.next());
				
			}
		
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return hospVOList;
	}

	
	public ArrayList<HospResvVO> selectHospResvInfo(int tt, String date) {
		// TODO Auto-generated method stub
		ArrayList<HospResvVO> resvList = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select hst.* from hospresvtime hst, dateinfo di "
				+ "where di.d_num = ? and di.rdate = ? and "
				+ "di.tprimary = hst.tprimary "
				+ "order by hst.tprimary, hst.time_num";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tt);
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resvList = new ArrayList<HospResvVO>();
				HospResvVO hospResvVO = null;

				do {
					hospResvVO = new HospResvVO();
					hospResvVO.setTprimary(rs.getInt("tprimary"));
					hospResvVO.setTime_num(rs.getInt("time_num"));
					hospResvVO.setRt(rs.getString("resv_time"));
					hospResvVO.setUser_id(rs.getString("user_id"));
					
					resvList.add(hospResvVO);

				}
				while(rs.next());

			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return resvList;
	}

	public int insertReservation(HospResvVO hospResvVO, String user_id, int tt, String time, String date) {
		// TODO Auto-generated method stub
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update hospresvtime set user_id = ?, hos_name = ?, pet_name = ? "
				+ "where tprimary = (select tprimary from dateinfo "
				+ "where d_num = ? and rdate = ?) "
				+ "and resv_time = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, hospResvVO.getHos_name());
			pstmt.setString(3, hospResvVO.getPet_name());
			pstmt.setInt(4, tt);
			pstmt.setString(5, date);
			pstmt.setString(6, time);

			updateCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCount;
	}

	public int insertResvDate(int dnum) {
		// TODO Auto-generated method stub
		int insertCount = 0;
		PreparedStatement pstmt = null;

		
		try {
	         
	         Calendar c1 = Calendar.getInstance();
	         Calendar c2 = Calendar.getInstance();
	         c2.add(Calendar.MONTH, +1);
	         Date d = new java.util.Date();
	         Date currentTime=c2.getTime();
	         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	         //Date타입으로 변경
	        

	         //Calendar 타입으로 변경 add()메소드로 1일씩 추가해 주기위해 변경
	         c1.setTime( d );
	         c2.setTime( currentTime );

	         //시작날짜와 끝 날짜를 비교해, 시작날짜가 작거나 같은 경우 출력

	         while( c1.compareTo( c2 ) !=1 ){

	         //출력
	         String sql = "insert into dateinfo(d_num, rdate, tprimary) "
	               + "select ?,?,t_seq.nextval from dual "
	               + "where not exists (select rdate from dateinfo where d_num = ? and rdate = ?)";         

	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, dnum);
	            pstmt.setString(2, df.format(c1.getTime()));
	            pstmt.setInt(3, dnum);
	            pstmt.setString(4, df.format(c1.getTime()));
	            insertCount = pstmt.executeUpdate();
	            if(insertCount <= 0) {
	               sql = "update dateinfo set rdate = ? where d_num = ? and rdate = ?";         

	               pstmt = con.prepareStatement(sql);
	               pstmt.setString(1, df.format(c1.getTime()));
	               pstmt.setInt(2, dnum);
	               pstmt.setString(3, df.format(c1.getTime()));
	               insertCount = pstmt.executeUpdate();
	            }

	         //시작날짜 + 1 일
	         c1.add(Calendar.DATE, 1);
	         }
	         

			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pstmt);

		}
		return insertCount;
	}

	public DateVO selectResvDate(int dnum) {
		// TODO Auto-generated method stub
		DateVO dateVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dateinfo where d_num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dnum);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dateVO = new DateVO();
				dateVO.setD_num(rs.getInt("d_num"));
				dateVO.setRdate(rs.getString("rdate"));
				dateVO.setTprimary(rs.getInt("tprimary"));
			
			}

			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return dateVO;
	}

	public int insertUser(int tprimary, String hosname, HospResvVO hospResvVO, String user_id) {
		// TODO Auto-generated method stub
		int insertCount = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = null;
			
			sql = "DELETE FROM hospresvtime "
					+ "WHERE tprimary IN (SELECT tprimary FROM dateinfo)";
			pstmt = con.prepareStatement(sql);
			insertCount = pstmt.executeUpdate();
			System.out.println(insertCount);
			for(int i = 0; i < hospResvVO.getResv_time().length; i++) {
				
				sql = "insert into hospresvtime(tprimary, time_num, resv_time) "
						+ "select h.tprimary, ?, ? from dateinfo h "
						+ "where h.tprimary = tprimary";
				
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, i);
				pstmt.setString(2, hospResvVO.getResv_time()[i]);
				
				insertCount = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return insertCount;
	}

	public HospVO selectMgHosInfo(String user_id) {
		// TODO Auto-generated method stub
		HospVO hospVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from hosinfo where user_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				hospVO = new HospVO();
				hospVO.setHosp_name(rs.getString("Hosp_name"));
				hospVO.setHosp_tel(rs.getString("Hosp_tel"));
				hospVO.setHosp_time(rs.getString("Hosp_time"));
				hospVO.setHosp_address2(rs.getString("Hosp_address2"));
				hospVO.setHosp_stop(rs.getString("Hosp_stop"));
				hospVO.setHosp_reason(rs.getString("Hosp_reason"));
			}
		
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return hospVO;
	}

	public int updateStop(String user_id) {
		// TODO Auto-generated method stub
		int updateCount = 0;
		PreparedStatement pstmt = null;



		String sql = "update hosinfo set Hosp_stop = ?, Hosp_reason = ? "
				+ "where user_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setString(2, null);
			pstmt.setString(3, user_id);
		
		
			
			
			updateCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return updateCount;
	}
}
