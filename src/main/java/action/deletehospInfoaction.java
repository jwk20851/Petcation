package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.DeleteUserService;
import vo.ActionForward;
import vo.HospVO;
import vo.UserVO;

public class deletehospInfoaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		HospVO hospVO = (HospVO)session.getAttribute("hospVO");
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		
		DeleteHospService deleteHospService = new DeleteHospService();
		boolean deleteHosp = deleteHospService.deleteHospInfo(userVO.getUser_id());
		
		
		ActionForward forward = null;
		forward = new ActionForward();

		
		if(deleteHosp) {
			session.setAttribute("hospVO", null);
			forward.setUrl("manageHospInfo.jsp");
				
		}
		else {
			forward.setUrl("manageHospInfo.jsp");
			forward.setRedirect(true);
			
		}
		
		
		
				
		return forward;
	}

}
