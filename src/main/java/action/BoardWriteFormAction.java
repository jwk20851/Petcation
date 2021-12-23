package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;
import vo.ReplyVO;

public class BoardWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//글을 작성하는 화면에서는 원글을 작성할 수도 있고, 답변글을 작성할 수도 있다.
		//작성하는 글이 답변글일때는 답변글에 필요한 값들이 파라미터 값으로 넘어옴
		
		int num = 0;
		if(request.getParameter("num") != null) {
			//답변글이면 ... 	넘어온다.
			num = Integer.parseInt(request.getParameter("num"));

		}
		
		//포워딩
		//작성할글이 답변글인지 정보를 공유하고 포워딩
		ReplyVO replyVO = new ReplyVO();		//vo로 가서 class만듬
		replyVO.setNum(num);

		
		request.setAttribute("replyVO", replyVO);
				
		ActionForward forward = new ActionForward();
		forward.setUrl("board/writeForm.jsp");
		
		return forward;
	}

}
