package vo;

//포워딩 정보를 저장하는 클래스
public class ActionForward {
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	private String url;
	private boolean redirect;
}
