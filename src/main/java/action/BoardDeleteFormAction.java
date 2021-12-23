package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.BoardUpdateFormService;
import vo.ActionForward;
import vo.BoardVO;

public class BoardDeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num = Integer.parseInt(request.getParameter("num"));		//num을 string으로 받아 int로 변환
		String pageNum = request.getParameter("pageNum");
		
		request.setAttribute("num", num); 
		request.setAttribute("pageNum", pageNum);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("board/deleteForm.jsp"); //최종적으로 페이지로 포워딩함.
		
		return forward;
	}

}
