package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.HopitalPwService;
import vo.ActionForward;
import vo.UserVO;

public class checkhosppwaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String passWord = request.getParameter("psw");
		HopitalPwService hopitalPwService = new HopitalPwService();
		UserVO checkpw = hopitalPwService.findHospPw(passWord);
		HttpSession session = request.getSession();

		ActionForward forward = new ActionForward();
		if (checkpw != null) {
			
			SendMail sendMail = new SendMail();
			boolean identsuccess = sendMail.sendHospReqEmail(checkpw.getUser_id(), checkpw.getUser_email(),checkpw.getUser_nickname());
			if(identsuccess) {
				session.setAttribute("userVO", checkpw);
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('요청 확인되면 연락드릴게요~');");
				out.println("</script>");
				forward.setUrl("main.jsp");
				forward.setRedirect(true);
			}
			
		} else {
			forward.setUrl("hoscheckpw.jsp");
			forward.setRedirect(true);
		}
		return forward;
	}

}
