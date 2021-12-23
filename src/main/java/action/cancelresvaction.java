package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CancelResvService;
import service.SearchHosResvService;
import vo.ActionForward;
import vo.HospResvVO;

public class cancelresvaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String[] timearr = new String[request.getParameterValues("tm").length];
		String[] tp = new String[request.getParameterValues("tp").length];
		System.out.println(timearr.length + "tp" + tp.length);
		for (int i = 0; i < tp.length; i++) {
			tp[i] = request.getParameterValues("tp")[i];
			timearr[i] = request.getParameterValues("tm")[i];
		}
		
		
		
		CancelResvService cancelResvService = new CancelResvService();
		boolean cancelResv = cancelResvService.getcancelResv(tp, timearr);
		
	      
	      
	      ActionForward forward = null;
	      forward = new ActionForward();
	      HttpSession session = request.getSession();

	      if(cancelResv) {
	         	         
	         forward.setUrl("findselfresv.pet");
	      }
	      else {
	         	         
	        forward.setUrl("findselfresv.pet");
	      }
	      
	      
	      
	            
	      return forward;
	}

}
