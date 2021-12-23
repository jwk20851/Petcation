package vo;

public class HospResvVO {
	private int tprimary;
	private int time_num;
	private String[] resv_time;
	private String rt;
	private String user_id;
	private String hos_name;
	private String pet_name;
	private String resvdate;
	
	
	public int getTprimary() {
		return tprimary;
	}
	public void setTprimary(int tprimary) {
		this.tprimary = tprimary;
	}
	public int getTime_num() {
		return time_num;
	}
	public void setTime_num(int time_num) {
		this.time_num = time_num;
	}
	public String[] getResv_time() {
		return resv_time;
	}
	public void setResv_time(String[] resv_time) {
		this.resv_time = resv_time;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	
	public String getHos_name() {
		return hos_name;
	}
	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}
	public String getPet_name() {
		return pet_name;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	public String getResvdate() {
		return resvdate;
	}
	public void setResvdate(String resvdate) {
		this.resvdate = resvdate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
