package action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardUpdateProService;
import vo.ActionForward;
import vo.BoardVO;

public class BoardUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardVO boardVO = new BoardVO();
		boardVO.setContent(request.getParameter("content"));
		boardVO.setNum(Integer.parseInt(request.getParameter("num")));	
		boardVO.setRate(Integer.parseInt(request.getParameter("rate")));
		boardVO.setReg_date(new Timestamp(System.currentTimeMillis()));	
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setWriter(request.getParameter("writer"));
		
		BoardUpdateProService boardUpdateProService = new BoardUpdateProService();
		
		boolean modifySuccess = boardUpdateProService.modifyArticle(boardVO);
		
		ActionForward forward = null;
		if(modifySuccess) {
			forward = new ActionForward();
			forward.setUrl("writeAfter.bo");
			forward.setRedirect(true);
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");			
			out.print("alert('수정실패')");			
			out.print("history.back();");			
			out.print("</script>");					
		}
		
		return forward;
	}

}
