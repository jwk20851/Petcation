package vo;


public class HospVO {
	private String Hosp_name;
	private String Hosp_tel;
	private String Hosp_time;
	private String Hosp_address1;
	private String Hosp_address2;
	private String Hosp_stop;
	private String Hosp_reason;
	private String Hosp_ReserveTime;
	private float Hosp_grade;
	private String user_id;
	private int dnum;
	
	public String getHosp_name() {
		return Hosp_name;
	}
	public void setHosp_name(String hosp_name) {
		Hosp_name = hosp_name;
	}
	
	public String getHosp_time() {
		return Hosp_time;
	}
	public void setHosp_time(String hosp_time) {
		Hosp_time = hosp_time;
	}
	public String getHosp_address1() {
		return Hosp_address1;
	}
	public void setHosp_address1(String hosp_address1) {
		Hosp_address1 = hosp_address1;
	}
	public String getHosp_address2() {
		return Hosp_address2;
	}
	public void setHosp_address2(String hosp_address2) {
		Hosp_address2 = hosp_address2;
	}
	
	public String getHosp_reason() {
		return Hosp_reason;
	}
	public void setHosp_reason(String hosp_reason) {
		Hosp_reason = hosp_reason;
	}
	
	public float getHosp_grade() {
		return Hosp_grade;
	}
	public void setHosp_grade(float hosp_grade) {
		Hosp_grade = hosp_grade;
	}
	public String getHosp_tel() {
		return Hosp_tel;
	}
	public void setHosp_tel(String hosp_tel) {
		Hosp_tel = hosp_tel;
	}
	public String getHosp_stop() {
		return Hosp_stop;
	}
	public void setHosp_stop(String hosp_stop) {
		Hosp_stop = hosp_stop;
	}
	public String getHosp_ReserveTime() {
		return Hosp_ReserveTime;
	}
	public void setHosp_ReserveTime(String hosp_ReserveTime) {
		Hosp_ReserveTime = hosp_ReserveTime;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	
	
}
