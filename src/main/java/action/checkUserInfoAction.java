package action;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CheckUserService;
import service.LoginService;
import vo.ActionForward;
import vo.UserVO;

public class checkUserInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("psw");
		
		CheckUserService checkUserService = new CheckUserService();
		UserVO checkUser = checkUserService.getUserInfo(name, id, pw);
		
		
		ActionForward forward = null;
		forward = new ActionForward();
		HttpSession session = request.getSession();

		
		if(checkUser != null) {
			session.setAttribute("userVO", checkUser);
			forward.setUrl("checkUserpop.jsp");
				
		}
		else {
			session.setAttribute("userVO", null);

			forward.setUrl("checkUserpop.jsp");
			forward.setRedirect(true);
			
		}
		
		
		
				
		return forward;
	}

}
