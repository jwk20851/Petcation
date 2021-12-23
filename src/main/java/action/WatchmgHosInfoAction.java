package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.WatchmgHosInfoService;
import vo.ActionForward;
import vo.HospVO;
import vo.UserVO;

public class WatchmgHosInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		String user_id = userVO.getUser_id();
		
		WatchmgHosInfoService watchmgHosInfoService = new WatchmgHosInfoService();
		HospVO watchmgHosinfo = watchmgHosInfoService.findmgHosInfo(user_id);
		ActionForward forward = null;
	    forward = new ActionForward();
		if(watchmgHosinfo != null) {
			request.setAttribute("hospVO", watchmgHosinfo);
			forward.setUrl("manageHospInfo.jsp");
		}
		else {
			forward.setUrl("manageHospInfo.jsp");
		}
		
	    
	    
		return forward;
	}

}
