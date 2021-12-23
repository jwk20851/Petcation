package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CheckUserService;
import service.SearchHosService;
import vo.ActionForward;
import vo.HospResvVO;
import vo.HospVO;

public class searchHospaction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      String searchHos = request.getParameter("shos");
      SearchHosService searchHosService = new SearchHosService();
      ArrayList<HospVO> findHosList = searchHosService.getFindHos(searchHos);
      
      //HospResvVO findHosresv = searchHosService.getFindHosresv(findHos);
      
      ActionForward forward = null;
      forward = new ActionForward();
      HttpSession session = request.getSession();

      if(findHosList != null) {
         

         request.setAttribute("findHosList", findHosList);
         request.setAttribute("showPop", "2");

         //session.setAttribute("hospResvVO", findHosresv);
         forward.setUrl("reservation.jsp");
         
         System.out.println("aaa");

      }
      else {
         
         request.setAttribute("showPop", "2");

         request.setAttribute("findHosList", null);
         
   
         forward.setUrl("reservation.jsp");

      }
      
      
      
            
      return forward;
   }

}