package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.JoinService;
import vo.ActionForward;
import vo.UserVO;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String user_Id = request.getParameter("id");
		String user_pw = request.getParameter("psw");
		String user_email = request.getParameter("email");
		String user_name = request.getParameter("name");
		String user_nickname = request.getParameter("nickname");
		String user_phone = request.getParameter("phonenumber");
		String user_postcode = request.getParameter("postalcode");
		String user_addr = request.getParameter("addr");
		String user_detailaddr = request.getParameter("detailaddr");
		
		//DTO(Data Transfer Object)
		UserVO userVO = new UserVO();
		userVO.setUser_id(user_Id);
		userVO.setUser_pw(user_pw);
		userVO.setUser_email(user_email);
		userVO.setUser_name(user_name);
		userVO.setUser_nickname(user_nickname);
		userVO.setUser_phone(user_phone);
		userVO.setUser_postcode(user_postcode);
		userVO.setUser_addr(user_addr);
		userVO.setUser_detailaddr(user_detailaddr);
		userVO.setUser_authority(1);
		
		
		JoinService joinService = new JoinService();
		boolean registSuccess = joinService.joinUser(userVO);
		
		ActionForward forward = null;
		if(registSuccess) {
			forward = new ActionForward();
			forward.setUrl("login.jsp");
			forward.setRedirect(true);
		}
		else {
			forward = new ActionForward();
			forward.setUrl("join.jsp");
			forward.setRedirect(true);
			
		}
		return forward;
	}

}
