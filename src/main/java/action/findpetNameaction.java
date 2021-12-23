package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.SearchHosResvService;
import service.SearchPetService;
import vo.ActionForward;
import vo.HospResvVO;
import vo.PetVO;
import vo.UserVO;

public class findpetNameaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	      HttpSession session = request.getSession();
	      UserVO userVO = (UserVO)session.getAttribute("userVO");
	      
	      SearchPetService searchPetService = new SearchPetService();
	      ArrayList<PetVO> findPetList = searchPetService.getFindPet(userVO.getUser_id());
	      
	      
	      ActionForward forward = null;
	      forward = new ActionForward();

	      if(findPetList != null) {
	    	  
	         session.setAttribute("findpetnameList", findPetList);
	         forward.setUrl("reservation.jsp");
	      }
	      else {
		         session.setAttribute("findpetnameList", null);
		         forward.setUrl("reservation.jsp");

	      }
	      
	      
	      
	            
	      return forward;
	}

}
