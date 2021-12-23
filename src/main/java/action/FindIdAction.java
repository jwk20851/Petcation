package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FindIdService;
import service.LoginService;
import vo.ActionForward;
import vo.UserVO;

public class FindIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		FindIdService findIdService = new FindIdService();
		UserVO findId = findIdService.getFindId(name, email);
		
		ActionForward forward = null;
		forward = new ActionForward();
		HttpSession session = request.getSession();
		
		if(findId != null) {
			
			session.setAttribute("userVO", findId);
			session.setAttribute("id", findId.getUser_id());
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("인증성공!");
			forward.setUrl("showId.jsp");
			forward.setRedirect(true);

			
		}
		else {
				session.setAttribute("id", null);
				
				System.out.println("인증실패!");
				forward.setUrl("showId.jsp");
				forward.setRedirect(true);

				
		}
		
		return forward;
	}

}
