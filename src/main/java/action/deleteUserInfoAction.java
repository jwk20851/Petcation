package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CheckUserService;
import service.DeleteUserService;
import vo.ActionForward;
import vo.UserVO;

public class deleteUserInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		
		
		DeleteUserService deleteUserService = new DeleteUserService();
		boolean deleteUser = deleteUserService.deleteUserInfo(userVO);
		
		
		ActionForward forward = null;
		forward = new ActionForward();

		
		if(deleteUser) {
			session.invalidate();
			forward.setUrl("main.jsp");
				
		}
		else {
			forward.setUrl("deleteUserInfo.jsp");
			forward.setRedirect(true);
			
		}
		
		
		
				
		return forward;
	}

}
