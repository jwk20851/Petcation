package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.SearchHosResvService;
import service.SearchHosService;
import vo.ActionForward;
import vo.HospResvVO;

public class watchHosRsvaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 int tt = Integer.parseInt(request.getParameter("tt"));
		 String hntt = request.getParameter("hntt");
		 String adr = request.getParameter("adr");
		 String date = request.getParameter("date");
		 String petname = request.getParameter("petname");
		 SearchHosResvService searchHosResvService = new SearchHosResvService();
		 ArrayList<HospResvVO> findHosResvList = null;
		 
		 if(date == "") {
			findHosResvList = new ArrayList<HospResvVO>();
			Date d = new java.util.Date();
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.DATE, 1);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			date = format.format(c.getTime());
			System.out.println(date);
		    findHosResvList = searchHosResvService.getFindHosresv(tt, date);

		 }else {
			findHosResvList = new ArrayList<HospResvVO>(); 	
			findHosResvList = searchHosResvService.getFindHosresv(tt, date);

		 }
	      
	      
	      ActionForward forward = null;
	      forward = new ActionForward();
	      HttpSession session = request.getSession();
	      
	      if(findHosResvList != null) {
	         
	         request.setAttribute("findHosResvList", findHosResvList);
	         request.setAttribute("petname", petname);
	         request.setAttribute("pickdate", date);
	         request.setAttribute("showPop", "1");
	         request.setAttribute("hntt", hntt);
	         request.setAttribute("adr", adr);
	         session.setAttribute("tt", tt);
	         
	         forward.setUrl("reservation.jsp");
	      }
	      else {
	         
	         request.setAttribute("showPop", "1");
	         
	         forward.setUrl("reservation.jsp");
	         forward.setRedirect(true);

	      }
	      
	      
	      
	            
	      return forward;
	}

}
