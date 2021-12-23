package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import vo.UserVO;

	public class UserDAO {
	private static Connection con;
	//singleton 패턴
	
	private static UserDAO instance;
	
	private UserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserDAO getInstance() {
		if(instance == null) {
			instance = new UserDAO();
		}
		
		return instance;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
		
	}

	public int insertUser(UserVO userVO) {
		// TODO Auto-generated method stub
		int insertCount = 0;
		PreparedStatement pstmt = null;



		String sql = "insert into userInfo(user_id, user_pw, user_email, user_name,"
				+ "user_nickname, user_phone, user_postcode, user_address, user_detailaddress, user_regDate, user_authority)"
				+ " values(?,?,?,?,?,?,?,?,?,to_char(sysdate, 'YYYY-MM-DD hh24:mi:ss'),?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userVO.getUser_id());
			pstmt.setString(2, userVO.getUser_pw());
			pstmt.setString(3, userVO.getUser_email());
			pstmt.setString(4, userVO.getUser_name());
			pstmt.setString(5, userVO.getUser_nickname());
			pstmt.setInt(6, Integer.parseInt(userVO.getUser_phone()));
			pstmt.setInt(7, Integer.parseInt(userVO.getUser_postcode()));
			pstmt.setString(8, userVO.getUser_addr());
			pstmt.setString(9, userVO.getUser_detailaddr());
			pstmt.setInt(10, userVO.getUser_authority());
			
			
			insertCount = pstmt.executeUpdate();
			
			sql = "insert into petinfo(pet_Num, user_Id, pet_Kind, pet_Name, pet_Age) values(petnum_seq.nextval, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userVO.getUser_id());
			pstmt.setString(2, "없음");
			pstmt.setString(3, "없음");
			pstmt.setInt(4, 0);
			
			insertCount = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return insertCount;
	}

	public UserVO selectLoginUser(String id, String passwd) {
		// TODO Auto-generated method stub
		UserVO userVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM userInfo WHERE user_id = ? and user_pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userVO = new UserVO();
				userVO.setUser_id(rs.getString("user_id"));
				userVO.setUser_pw(rs.getString("user_pw"));
				userVO.setUser_email(rs.getString("user_email"));
				userVO.setUser_name(rs.getString("user_name"));
				userVO.setUser_nickname(rs.getString("user_nickname"));
				userVO.setUser_phone(rs.getString("user_phone"));
				userVO.setUser_postcode(rs.getString("user_postcode"));
				userVO.setUser_addr(rs.getString("user_address"));
				userVO.setUser_detailaddr(rs.getString("user_detailaddress"));
				userVO.setUser_regDate(rs.getString("user_regDate"));
				userVO.setUser_authority(rs.getInt("user_authority"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userVO;
	}

	public UserVO selectId(String name, String email) {
		// TODO Auto-generated method stub
		UserVO userVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM userInfo WHERE user_name = ? and user_email = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userVO = new UserVO();
				userVO.setUser_id(rs.getString("user_id"));
				userVO.setUser_pw(rs.getString("user_pw"));
				userVO.setUser_email(rs.getString("user_email"));
				userVO.setUser_name(rs.getString("user_name"));
				userVO.setUser_nickname(rs.getString("user_nickname"));
				userVO.setUser_phone(rs.getString("user_phone"));
				userVO.setUser_postcode(rs.getString("user_postcode"));
				userVO.setUser_addr(rs.getString("user_address"));
				userVO.setUser_regDate(rs.getString("user_regDate"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userVO;
	}

	public UserVO selectOlId(String id) {
		// TODO Auto-generated method stub
		UserVO userVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM userInfo WHERE user_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userVO = new UserVO();
				userVO.setUser_id(rs.getString("user_id"));
				userVO.setUser_pw(rs.getString("user_pw"));
				userVO.setUser_email(rs.getString("user_email"));
				userVO.setUser_name(rs.getString("user_name"));
				userVO.setUser_nickname(rs.getString("user_nickname"));
				userVO.setUser_phone(rs.getString("user_phone"));
				userVO.setUser_postcode(rs.getString("user_postcode"));
				userVO.setUser_addr(rs.getString("user_address"));
				userVO.setUser_regDate(rs.getString("user_regDate"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userVO;
	}

	

	public UserVO selectUserInfo(String id, String email) {
		// TODO Auto-generated method stub

				UserVO userVO = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = "SELECT * FROM userInfo WHERE user_id = ? and user_email = ?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, email);

					
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						userVO = new UserVO();
						userVO.setUser_id(rs.getString("user_id"));
						userVO.setUser_pw(rs.getString("user_pw"));
						userVO.setUser_email(rs.getString("user_email"));
						userVO.setUser_name(rs.getString("user_name"));
						userVO.setUser_nickname(rs.getString("user_nickname"));
						userVO.setUser_phone(rs.getString("user_phone"));
						userVO.setUser_postcode(rs.getString("user_postcode"));
						userVO.setUser_addr(rs.getString("user_address"));
						userVO.setUser_detailaddr(rs.getString("user_detailaddress"));
						userVO.setUser_regDate(rs.getString("user_regDate"));
						
						
					}
					
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				finally {
					try {
						rs.close();
						pstmt.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
				return userVO;
	}

	public int updatePw(UserVO userVO) {
		// TODO Auto-generated method stub
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update userInfo set user_pw = ? where user_id = ? and user_email = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userVO.getUser_pw());
			pstmt.setString(2, userVO.getUser_id());
			pstmt.setString(3, userVO.getUser_email());
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

	public UserVO selectchPw(String pw, String user_id) {
		// TODO Auto-generated method stub
		UserVO userVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM userInfo WHERE user_id = ? and user_pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userVO = new UserVO();
				userVO.setUser_id(rs.getString("user_id"));
				userVO.setUser_pw(rs.getString("user_pw"));
				userVO.setUser_email(rs.getString("user_email"));
				userVO.setUser_name(rs.getString("user_name"));
				userVO.setUser_nickname(rs.getString("user_nickname"));
				userVO.setUser_phone(rs.getString("user_phone"));
				userVO.setUser_postcode(rs.getString("user_postcode"));
				userVO.setUser_addr(rs.getString("user_address"));
				userVO.setUser_detailaddr(rs.getString("user_detailaddress"));
				userVO.setUser_regDate(rs.getString("user_regDate"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userVO;
	}

	public int updateUser(UserVO userVO) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update userInfo set user_pw = ?, user_email = ?, user_name = ?, "
				+ "user_nickname = ?, user_phone = ?, user_postcode = ?, user_address = ?, user_detailaddress = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userVO.getUser_pw());
			pstmt.setString(2, userVO.getUser_email());
			pstmt.setString(3, userVO.getUser_name());
			pstmt.setString(4, userVO.getUser_nickname());
			pstmt.setString(5, userVO.getUser_phone());
			pstmt.setString(6, userVO.getUser_postcode());
			pstmt.setString(7, userVO.getUser_addr());
			pstmt.setString(8, userVO.getUser_detailaddr());
			
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

	public UserVO selectUserInfo(String name, String id, String pw) {
		// TODO Auto-generated method stub
		UserVO userVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM userInfo WHERE user_name = ? and user_id = ? and user_pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userVO = new UserVO();
				userVO.setUser_id(rs.getString("user_id"));
				userVO.setUser_pw(rs.getString("user_pw"));
				userVO.setUser_email(rs.getString("user_email"));
				userVO.setUser_name(rs.getString("user_name"));
				userVO.setUser_nickname(rs.getString("user_nickname"));
				userVO.setUser_phone(rs.getString("user_phone"));
				userVO.setUser_postcode(rs.getString("user_postcode"));
				userVO.setUser_addr(rs.getString("user_address"));
				userVO.setUser_detailaddr(rs.getString("user_detailaddress"));
				userVO.setUser_regDate(rs.getString("user_regDate"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userVO;
	}

	public int deleteUser(UserVO userVO) {
		// TODO Auto-generated method stub
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM userInfo WHERE user_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userVO.getUser_id());
			deleteCount = pstmt.executeUpdate();
			
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
		return deleteCount;
	}
	public UserVO selectHospPw(String passWord) {
	      UserVO userVO = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = "SELECT * FROM userInfo WHERE user_pw = ?";
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, passWord);
	         
	         rs = pstmt.executeQuery();

	         if (rs.next()) {
	            userVO = new UserVO();
	            userVO.setUser_id(rs.getString("user_id"));
	            userVO.setUser_pw(rs.getString("user_pw"));
	            userVO.setUser_email(rs.getString("user_email"));
	            userVO.setUser_name(rs.getString("user_name"));
	            userVO.setUser_nickname(rs.getString("user_nickname"));
	            userVO.setUser_phone(rs.getString("user_phone"));
	            userVO.setUser_postcode(rs.getString("user_postcode"));
	            userVO.setUser_addr(rs.getString("user_address"));
	            userVO.setUser_detailaddr(rs.getString("user_detailaddress"));
	            userVO.setUser_regDate(rs.getString("user_regDate"));
	            userVO.setUser_authority(rs.getInt("user_authority"));

	         }

	      } catch (SQLException e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      } finally {
	         try {
	            rs.close();
	            pstmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return userVO;
	   }
	
}
