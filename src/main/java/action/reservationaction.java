package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ReservationService;
import vo.ActionForward;
import vo.HospResvVO;
import vo.UserVO;

public class reservationaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    HttpSession session = request.getSession();
	    String tr = String.valueOf(session.getAttribute("tt"));
		int tt = Integer.parseInt(tr);
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		String petname = request.getParameter("petname");
		String hosname = request.getParameter("sendhn");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String user_id = userVO.getUser_id();
		
		HospResvVO hospResvVO = new HospResvVO();
		hospResvVO.setTprimary(tt);

		hospResvVO.setPet_name(petname);
		hospResvVO.setHos_name(hosname);
		
	    ReservationService reservationService = new ReservationService();
	    boolean resvsuccess = reservationService.setReservation(hospResvVO, user_id, tt, time, date);
	     
	      
	      
	      ActionForward forward = null;
	      forward = new ActionForward();

	      if(resvsuccess) {
	         forward.setUrl("findselfresv.pet");

	      }
	      else {
	    	 
	         forward.setUrl("reservation.jsp");

	      }
	      
	      
	      
	            
	      return forward;
	}

}
