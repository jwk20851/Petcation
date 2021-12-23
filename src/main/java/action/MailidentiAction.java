package action;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;
import vo.UserVO;

public class MailidentiAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String user_email = request.getParameter("email");
		String equalnumber = request.getParameter("eqn");
		//DTO(Data Transfer Object)
		UserVO userVO = new UserVO();
		
		userVO.setUser_email(user_email);
		
		SendMail sendMail = new SendMail();
		boolean identsuccess = sendMail.sendEmail(user_email, equalnumber);
		
		HttpSession session = request.getSession();
		ActionForward forward = null;
		if(identsuccess == true) {
			//request.setAttribute("eqn", Integer.toString(eqn));
			session.setAttribute("email", user_email);
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("인증성공");

			PrintWriter out = response.getWriter();
			forward = new ActionForward();
			forward.setUrl("checkJoinEmail.jsp");
			forward.setRedirect(true);
			
		}
		else {
			session.setAttribute("email", null);
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("인증실패");
			forward = new ActionForward();
			forward.setUrl("checkJoinEmail.jsp");
			forward.setRedirect(true);
			
		}
		
		
		return forward;
	
	}

}
