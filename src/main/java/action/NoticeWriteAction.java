package action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardListService;
import service.BoardWriteProService;
import vo.ActionForward;
import vo.BoardVO;
import vo.PageVO;

public class NoticeWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setContent(request.getParameter("content"));
		boardVO.setNum(Integer.parseInt(request.getParameter("num")));
		boardVO.setReg_date(new Timestamp(System.currentTimeMillis()));	
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setWriter(request.getParameter("writer"));
		
		BoardWriteProService boardWriteProService = new BoardWriteProService();	//service객체만듬.
		boolean registSuccess = boardWriteProService.registArticle(boardVO);
		
		ActionForward forward = null;
		if(registSuccess) {
			forward = new ActionForward();
			forward.setUrl("writeAfter.bo");
			forward.setRedirect(true);	//성공하면 목록보기 다시요청 함.
			
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
