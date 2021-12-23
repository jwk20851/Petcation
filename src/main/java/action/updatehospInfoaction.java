package action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UpdateHospService;
import service.UpdateUserService;
import vo.ActionForward;
import vo.DateVO;
import vo.HospResvVO;
import vo.HospVO;
import vo.UserVO;

public class updatehospInfoaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String hosname = request.getParameter("hosname");
		String phonenum = request.getParameter("phonenum");
		String location = request.getParameter("location");
		String stopduration = request.getParameter("stopduration");
		String stopreason = request.getParameter("stopreason");
		String storetime = request.getParameter("storetime1") + "~" + request.getParameter("storetime2");
		String[] resvtimes = request.getParameterValues("hoslocatcont");
		
		
		ActionForward forward = null;
		
		forward = new ActionForward();
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		String user_id = userVO.getUser_id();
		HospVO hospVO = new HospVO();
		hospVO.setHosp_name(hosname);
		hospVO.setHosp_tel(phonenum);
		hospVO.setHosp_address2(location);
		hospVO.setHosp_stop(stopduration);
		hospVO.setHosp_reason(stopreason);
		hospVO.setHosp_time(storetime);
		HospResvVO hospResvVO = new HospResvVO();
		hospResvVO.setResv_time(resvtimes);
		


		
		
		UpdateHospService updateHospService = new UpdateHospService();
		boolean updateinfo = updateHospService.getupdateHosp(hospVO,user_id);
		HospVO hovo = updateHospService.getfindHosp(user_id);

		boolean insertresvdate = updateHospService.getinsertDate(hovo.getDnum());
		DateVO resvdate = updateHospService.getfindResvDate(hovo.getDnum());
		boolean insertresvtime = updateHospService.getinsertHosp(resvdate.getTprimary(), hovo.getHosp_name(), hospResvVO, user_id);
		
		
		if(updateinfo && insertresvdate && insertresvtime) {
			request.setAttribute("hospVO", hovo);
			forward.setUrl("manageHospInfo.jsp");
			forward.setRedirect(false);
		}
		else {
			forward.setUrl("manageHospInfo.jsp");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
