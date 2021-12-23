package action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardWriteProService;
import vo.ActionForward;
import vo.BoardVO;

public class BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ����ڰ� �ۼ��� �����͵�(�Ķ���Ͱ���)�� �� �޾Ƽ� VO(DTO)��ü�� �Ҵ��ϰ�
		//����Ŭ������ ����
		BoardVO boardVO = new BoardVO();
		boardVO.setContent(request.getParameter("content"));
		boardVO.setNum(Integer.parseInt(request.getParameter("num")));
		boardVO.setRate(Integer.parseInt(request.getParameter("rate")));
		boardVO.setReg_date(new Timestamp(System.currentTimeMillis()));	
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setWriter(request.getParameter("writer"));
		
		BoardWriteProService boardWriteProService = new BoardWriteProService();	//service��ü����.
		boolean registSuccess = boardWriteProService.registArticle(boardVO);
		
		ActionForward forward = null;
		if(registSuccess) {
			forward = new ActionForward();
			forward.setUrl("writeAfter.bo");
			forward.setRedirect(true);	//�����ϸ� ��Ϻ��� �ٽÿ�û ��.
			
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��Ͻ���')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
