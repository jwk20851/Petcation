package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FindPwService;
import service.UpdateUserService;
import vo.ActionForward;
import vo.UserVO;

public class updateUserInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String user_pw = request.getParameter("psw");
		String user_email = request.getParameter("email");
		String user_name = request.getParameter("name");
		String user_nickname = request.getParameter("nickname");
		String user_phone = request.getParameter("phonenumber");
		String user_postcode = request.getParameter("postalcode");
		String user_addr = request.getParameter("addr");
		String user_detailaddr = request.getParameter("detailaddr");
		UserVO userVO = null;
		ActionForward forward = null;
		
		forward = new ActionForward();
		HttpSession session = request.getSession();
		userVO = (UserVO) session.getAttribute("userVO");
		
		if(user_pw != "") {
			userVO.setUser_pw(user_pw);

		}
		userVO.setUser_email(user_email);
		userVO.setUser_name(user_name);
		userVO.setUser_nickname(user_nickname);
		userVO.setUser_phone(user_phone);
		userVO.setUser_postcode(user_postcode);
		userVO.setUser_addr(user_addr);
		userVO.setUser_detailaddr(user_detailaddr);
		
		UpdateUserService updateUserService = new UpdateUserService();
		boolean updateinfo = updateUserService.getupdateUser(userVO);
		
		if(updateinfo) {
			forward.setUrl("manageUserInfo.jsp");
			forward.setRedirect(true);
		}
		else {
			forward.setUrl("manageUserInfo.jsp");
		}
		
		return forward;
	}

}
