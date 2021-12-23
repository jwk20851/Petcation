package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CancelStopService;
import vo.ActionForward;
import vo.UserVO;

public class CancelStopAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		String user_id = userVO.getUser_id();
		
		CancelStopService cancelStopService = new CancelStopService();
		boolean cancelstop = cancelStopService.updatestop(user_id); 
		ActionForward forward = null;
		
		forward = new ActionForward();
		if(cancelstop) {
			forward.setUrl("manageHospInfo.jsp");
		}
		else {
			forward.setUrl("manageHospInfo.jsp");
		}
		return forward;
	}

}
