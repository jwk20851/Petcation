package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ViewReserverService;
import vo.ActionForward;
import vo.DateVO;
import vo.HospResvVO;
import vo.PetVO;
import vo.UserVO;

public class ViewReserverAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String tprmiary = request.getParameter("resvtpri");
		String rt = request.getParameter("resvrt");
		String petname = request.getParameter("resvpetname");
		String rdate = request.getParameter("rdate");
		String username = request.getParameter("resvusername");
		String userid = request.getParameter("resvuserid");
		String userphone = request.getParameter("resvuserphone");
		
		HospResvVO hospResvVO = new HospResvVO();
		hospResvVO.setRt(rt);
		hospResvVO.setPet_name(petname);
		hospResvVO.setTprimary(Integer.parseInt(tprmiary));
		
		DateVO dateVO = new DateVO();
		dateVO.setRdate(rdate);
		
		UserVO userVO = new UserVO();
		userVO.setUser_name(username);
		userVO.setUser_id(userid);
		userVO.setUser_phone(userphone);

		
		HttpSession session = request.getSession();
		
		ViewReserverService viewReserverService = new ViewReserverService();
		PetVO findResverinfo = viewReserverService.getResverInfo(hospResvVO, dateVO, userVO);
		
		
		request.setAttribute("hospResvVO", hospResvVO);
		request.setAttribute("reserverVO", userVO);
		request.setAttribute("resvdateVO", dateVO);
		request.setAttribute("resvpetVO", findResverinfo);
		ActionForward forward = new ActionForward();
		forward.setUrl("checkReserve.jsp");		
		
		return forward;
	}

}
