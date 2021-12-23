package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardUpdateFormService;
import vo.ActionForward;
import vo.BoardVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num = Integer.parseInt(request.getParameter("num"));		//num을 string으로 받아 int로 변환
		String pageNum = request.getParameter("pageNum");
		
		BoardUpdateFormService boardUpdateFormService = new BoardUpdateFormService();
		
		BoardVO article = boardUpdateFormService.getUpdateArticle(num); 		//수정할 대상의 글 가져오기. ,num으로 글 구분하기. 인자로 전달
		request.setAttribute("article", article); //데이터 공유하기
		request.setAttribute("pageNum", pageNum); //글 수정 끝나고 원래 페이지로 되돌아 가야하기 때문에 보던페이지번호 전달역할
		
		ActionForward forward = new ActionForward();
		forward.setUrl("board/updateForm.jsp"); //최종적으로 페이지로 포워딩함.
		
		return forward;
	}

}
