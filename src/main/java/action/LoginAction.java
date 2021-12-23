package action;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import vo.ActionForward;
import vo.UserVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("psw");
		String checkbox = request.getParameter("remeberId");// 체크박스의 체크여부 넘어온다.
		
		LoginService loginService = new LoginService();
		UserVO loginUser = loginService.getLoginUser(id, pw);
		Cookie cookie = new Cookie("id", id);// 일단 쿠키 생성
		
		if (checkbox != null) { // 체크박스 체크여부에 따라 쿠키 저장 확인
			// 체크박스 체크 되었을 때
			// 쿠키 저장
			response.addCookie(cookie);
			System.out.println("action");
			System.out.println(cookie);
		} else {
			// 체크박스 체크 해제되었을 때
			// 쿠키 유효시간 0으로 해서 브라우저에서 삭제하게 한다.
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		ActionForward forward = null;

		// id , pwd 에 null 체크 반드시 하기
		if ((id != null) && (pw != null)) {
			if(loginUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userVO", loginUser);
				forward = new ActionForward();
				forward.setUrl("main.jsp");
				forward.setRedirect(true);
				
			}
			else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('인증실패')");
				out.println("history.back()");	//history.go(-1)
				out.println("</script>");
			}
		}
		
		
				
		return forward;
	}

}
