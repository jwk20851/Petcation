package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardListService;
import service.ResvListService;
import vo.ActionForward;
import vo.BoardVO;
import vo.DateVO;
import vo.HospResvVO;
import vo.HospVO;
import vo.PageVO;
import vo.UserVO;

public class ViewReserveListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageSize = 10; 	
		String pageNum = request.getParameter("pageNum");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		String user_id = userVO.getUser_id();
		if(pageNum == null) {			
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
	
		int startRow = (currentPage - 1) * pageSize + 1;
		
		
		int count = 0;		
		int number = 0;		
		
		ResvListService resvListService = new ResvListService();			
		List<HospResvVO> resvList = null;
		List<DateVO> resvdate = null;
		List<UserVO> reservernameList = null;
		//List<HospVO> resvHosList = null;
		count = resvListService.getArticleCount(user_id);		
		
		if(count > 0) {
			resvList = resvListService.getResvList(startRow, pageSize, user_id);			
			resvdate = resvListService.getResvDateList(startRow, pageSize, user_id);
			reservernameList = resvListService.getResvName(startRow, pageSize, user_id);
			//resvHosList = resvListService.getResvHosTel(startRow, pageSize, user_id);
		}
		
		
		number = count - (currentPage - 1) * pageSize;				
		
		
		
		int pageCount = 0;		
		int startPage = 0;		
		int endPage = 0;
		
		if(count > 0) {
			pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			
			
			startPage = (int)((currentPage - 1)/ 10) * 10 + 1;
			
			
			endPage = startPage + 9;
			
			
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		request.setAttribute("viewReserveList", resvList);
		request.setAttribute("resvdateList", resvdate);
		request.setAttribute("reservernameList", reservernameList);
		//request.setAttribute("resvHosList", resvHosList);
		PageVO pageVO = new PageVO();			
		
		pageVO.setCount(count);					
		pageVO.setCurrentPage(currentPage);
		pageVO.setEndPage(endPage);
		pageVO.setNumber(number);
		pageVO.setPageCount(pageCount);
		pageVO.setStartPage(startPage);
		
		request.setAttribute("pageVO", pageVO);
		ActionForward forward = new ActionForward();
		forward.setUrl("board/viewReserveList.jsp");		
		
		return forward;
	}

}
