package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FinishTreatService;
import vo.ActionForward;
import vo.DateVO;
import vo.HospResvVO;
import vo.PetVO;
import vo.UserVO;

public class FintreatAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int tprimary = Integer.parseInt(request.getParameter("tprimary"));
		String username = request.getParameter("username");
		String rdate = request.getParameter("rdate");
		String rt = request.getParameter("rt");
		String petname = request.getParameter("petname");
		String petInfodetail = request.getParameter("petInfodetail");
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		String user_id = userVO.getUser_id();
		FinishTreatService finishTreatService = new FinishTreatService();
		boolean finTreat = finishTreatService.getFinTreat(tprimary, user_id, username, rdate, rt, petname, petInfodetail);
		ActionForward forward = new ActionForward();
		if(finTreat) {
			forward.setUrl("checkReserve.jsp");		

		}
		else {
			forward.setUrl("checkReserve.jsp");		
		}
		
		return forward;
	}

}
