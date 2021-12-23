package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AmtmListAction;
import action.BoardContentAction;
import action.BoardDeleteFormAction;
import action.BoardDeleteProAction;
import action.BoardListAction;
import action.BoardUpdateFormAction;
import action.BoardUpdateProAction;
import action.BoardWriteFormAction;
import action.BoardWriteProAction;
//import action.BookmarkAction;
import action.NoticeListAction;
import action.NoticeWriteAction;
import action.ViewAction;
import action.ViewMTMListAction;
import action.ViewReserveListAction;
import action.ViewReviewListAction;
import action.WriteAfterAction;
import vo.ActionForward;

/**
 * Servlet implementation class BoardFrontController
 */
//@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1. 요청파악
      String requestURI = request.getRequestURI();
      //요청 URL : http://localhost:8088/MemberProject/login.me
      //requestURI : /MemberProject/login.me
      
      String contextPath = request.getContextPath();
      //애플리케이션 경로
      //contextgPath : /MemberProject
      
      String command = requestURI.substring(contextPath.length());
      System.out.println("command = " + command);
      
      //2. 각 요청별로 요청처리
      //다형성을 사용해서
      Action action = null;
      ActionForward forward = null;
      
      if(command.equals("/boardWriteForm.bo")) {
         action = new BoardWriteFormAction();      //해당 요청을 처리할 액션 생성
         
         try {
            forward = action.execute(request, response);   //요청 처리 후 포워딩 정보를 반환받음
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      else if(command.equals("/boardWritePro.bo")) {
    	  action = new BoardWriteProAction();      //해당 요청을 처리할 액션 생성
    	  
    	  try {
    		  forward = action.execute(request, response);   //요청 처리 후 포워딩 정보를 반환받음
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      
      else if(command.equals("/boardList.bo")) {		//1.위에서 복사해서 url바꾸고
    	  action = new BoardListAction();     			// 이 부분도 바꾸고 action 생성
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/boardContent.bo")) {		
    	  action = new BoardContentAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/boardUpdateForm.bo")) {	//글수정 폼 화면	
    	  action = new BoardUpdateFormAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      
      else if(command.equals("/boardUpdatePro.bo")) {	//글수정 구현
    	  action = new BoardUpdateProAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/boardDeleteForm.bo")) {	//글 삭제 폼출력
    	  action = new BoardDeleteFormAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/boardDeletePro.bo")) {	//글 삭제 구현
    	  action = new BoardDeleteProAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/writeAfter.bo")) {	//작성한리뷰
    	  action = new WriteAfterAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
		/*else if(command.equals("/bookmark.bo")) {	//즐겨찾기관리
		  action = new BookmarkAction();     			
		  
		  try {
			  forward = action.execute(request, response);   
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		}*/
		/*else if(command.equals("/noticeWrite.bo")) {	//공지사항 등록화면
		  action = new NoticeWriteAction();     			
		  
		  try {
			  forward = action.execute(request, response);   
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		}*/
		/*else if(command.equals("/noticeAList.bo")) {	//공지사항 리스트
		  action = new NoticeListAction();     			
		  
		  try {
			  forward = action.execute(request, response);   
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		}*/
      else if(command.equals("/amtmList.bo")) {	//1대1 문의내역 리스트
    	  action = new AmtmListAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/viewNoticeList.bo")) {	
    	  action = new ViewAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/viewMTMList.bo")) {	
    	  action = new ViewMTMListAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/viewReserveList.bo")) {	
    	  action = new ViewReserveListAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/viewReviewList.bo")) {	
    	  action = new ViewReviewListAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      
      //3. forward 객체의 정보를 사용해서 포워딩
      if(forward != null) {
         //요청처리가 제대로 됐으면...
         if(forward.isRedirect()) {
            response.sendRedirect(forward.getUrl());
         }
         else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getUrl());
            dispatcher.forward(request, response);
         }
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      doGet(request, response);
   }

}