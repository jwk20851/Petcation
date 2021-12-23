package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CheckOlIdService;
import service.FindIdService;
import vo.ActionForward;
import vo.UserVO;

public class CheckOlIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		
		CheckOlIdService checkOlIdService = new CheckOlIdService();
		UserVO checkOlID = checkOlIdService.getCheckOlId(id);
		
		ActionForward forward = null;
		forward = new ActionForward();
		HttpSession session = request.getSession();
		
		if(checkOlID != null) {
			session.setAttribute("id", checkOlID.getUser_id());
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("인증성공!");
			forward.setUrl("checkOlId.jsp");
			forward.setRedirect(true);

			
		}
		else {
				session.setAttribute("id", null);
				System.out.println("인증실패!");
				forward.setUrl("checkOlId.jsp");
				forward.setRedirect(true);

				
		}
		
		return forward;
	}

}
