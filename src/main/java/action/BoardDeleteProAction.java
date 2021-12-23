package action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardDeleteProService;
import vo.ActionForward;
import vo.BoardVO;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num =Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
		
		boolean deleteSuccess = boardDeleteProService.deleteArticle(num);
		System.out.println(deleteSuccess);
		ActionForward forward = null;
		if(deleteSuccess) {
			forward = new ActionForward();
			forward.setUrl("writeAfter.bo");
			forward.setRedirect(true);
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");			
			out.print("alert('삭제실패')");			
			out.print("history.back();");			
			out.print("</script>");					
		}
		
		return forward;
	}

}
