package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FindSelfResvService;
import service.ReservationService;
import vo.ActionForward;
import vo.DateVO;
import vo.HospResvVO;
import vo.PetVO;
import vo.UserVO;

public class findselfresvaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	    
		UserVO userVO = (UserVO)session.getAttribute("userVO");
		String user_id = userVO.getUser_id();
		
	    
	    FindSelfResvService findSelfResvService = new FindSelfResvService();
	    ArrayList<HospResvVO> findresv =  findSelfResvService.getResvList(user_id);
	    ArrayList<PetVO> findresvpet = findSelfResvService.getResvPetList(user_id, findresv); 
	    ArrayList<DateVO> findresvdate = findSelfResvService.getResvDateList(user_id, findresv);

	      ActionForward forward = null;
	      forward = new ActionForward();

	      if(findresv != null && findresvpet != null) {
	    	  request.setAttribute("findResvList", findresv);
	    	  request.setAttribute("findresvpet", findresvpet);
	    	  request.setAttribute("findresvdate", findresvdate);
	         forward.setUrl("checkMyRsv.jsp");

	      }
	      else {

	         forward.setUrl("checkMyRsv.jsp");
	         forward.setRedirect(true);

	      }
	      
	      
	      
	            
	      return forward;
	}

}
