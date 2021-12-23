package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardListService;
import vo.ActionForward;
import vo.BoardVO;
import vo.PageVO;

public class WriteAfterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageSize = 10; 		//한페이지당 출력되는 글의 개수
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {			//QnA페이지일때 안넘어 오기때문에 페이지 번호 소용없음.
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		//하단에서 페이지번호를 연산해서 페이징처리를 할때
		//연산이 제대로 되도록 정수 타입으로 변경
		int startRow = (currentPage - 1) * pageSize + 1;
		//해당 페이지에 출력되는 첫번째 레코드의 번호
		//현재페이지 : 1
		//startRow : (1 - 1) * 10 + 1 ===> 1
		//현재페이지 : 2
		//startRow : (2 - 1) * 10 + 1 ===> 11
		
		int count = 0;		//총 글의 개수
		int number = 0;		//해당 페이지에 첫번째로 출력되는 글의 번호
		
		BoardListService boardListService = new BoardListService();			// controller 에서 넘어옴 2. 위에코드 작성후 BoardListService 만들기. service로 이동
		List<BoardVO> articleList = null;
		count = boardListService.getArticleCount();		//4.작성후 BoardListService로 이동.
		
		if(count > 0) {
			articleList = boardListService.getArticleList(startRow, pageSize);			//7.getArticleList만들러 BoardListService 으로 이동
		}
		
		
		number = count - (currentPage - 1) * pageSize;				//10. DAO에서 넘어와 나머지 작성.
		//전체글의 개수 : 132
		//현재 페이지 : 1
		//첫번째글의 번호 : 132 - (1 - 1) * 10 : 132
		//전체글의 개수 : 132
		//현재 페이지 : 2
		//첫번째글의 번호 : 132 - (2 - 1) * 10 : 122
		
		//페이징처리
		int pageCount = 0;		//총 페이지의 개수
		int startPage = 0;		//동일 페이지 그룹에서 첫 페이지 번호
		int endPage = 0;
		
		if(count > 0) {
			pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			//글 : 132
			
			startPage = (int)((currentPage - 1)/ 10) * 10 + 1;
			//현재 페이지 1 (1 - 1) / 10 * 10 + 1 : 1
			//현재 페이지 7 (7 - 1) / 10 * 10 + 1 : 1
			
			endPage = startPage + 9;
			
			//마지막 페이지 그룹일때
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		request.setAttribute("articleList", articleList);
		PageVO pageVO = new PageVO();			//11.vo로 작성하러 감.
		
		pageVO.setCount(count);					//13. vo에서 선언한 것 넣음.
		pageVO.setCurrentPage(currentPage);
		pageVO.setEndPage(endPage);
		pageVO.setNumber(number);
		pageVO.setPageCount(pageCount);
		pageVO.setStartPage(startPage);
		
		request.setAttribute("pageVO", pageVO);
		ActionForward forward = new ActionForward();
		forward.setUrl("board/manageWrittenReview.jsp");		//14. 페이지에 나오는 jsp파일 작성하기.
		
		return forward;
	}

}
