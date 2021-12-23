package vo;

public class PageVO {
	private int number;		//해당 페이지에 첫번째로 출력되는 글의 번호
	private int count;		//총 글의 개수
	private int currentPage;	//현재페이지			//12.getter and setter �� action���� �̵�
	private int pageCount;	//총 페이지의 개수
	private int startPage;	//동일 페이지 그룹에서 첫 페이지 번호
	private int endPage;
	private int pageNum;	//현재페이지번호
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	

}
