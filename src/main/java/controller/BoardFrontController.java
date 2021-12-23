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
      //1. ��û�ľ�
      String requestURI = request.getRequestURI();
      //��û URL : http://localhost:8088/MemberProject/login.me
      //requestURI : /MemberProject/login.me
      
      String contextPath = request.getContextPath();
      //���ø����̼� ���
      //contextgPath : /MemberProject
      
      String command = requestURI.substring(contextPath.length());
      System.out.println("command = " + command);
      
      //2. �� ��û���� ��ûó��
      //�������� ����ؼ�
      Action action = null;
      ActionForward forward = null;
      
      if(command.equals("/boardWriteForm.bo")) {
         action = new BoardWriteFormAction();      //�ش� ��û�� ó���� �׼� ����
         
         try {
            forward = action.execute(request, response);   //��û ó�� �� ������ ������ ��ȯ����
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
      else if(command.equals("/boardWritePro.bo")) {
    	  action = new BoardWriteProAction();      //�ش� ��û�� ó���� �׼� ����
    	  
    	  try {
    		  forward = action.execute(request, response);   //��û ó�� �� ������ ������ ��ȯ����
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      
      else if(command.equals("/boardList.bo")) {		//1.������ �����ؼ� url�ٲٰ�
    	  action = new BoardListAction();     			// �� �κе� �ٲٰ� action ����
    	  
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
      else if(command.equals("/boardUpdateForm.bo")) {	//�ۼ��� �� ȭ��	
    	  action = new BoardUpdateFormAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      
      else if(command.equals("/boardUpdatePro.bo")) {	//�ۼ��� ����
    	  action = new BoardUpdateProAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/boardDeleteForm.bo")) {	//�� ���� �����
    	  action = new BoardDeleteFormAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/boardDeletePro.bo")) {	//�� ���� ����
    	  action = new BoardDeleteProAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      else if(command.equals("/writeAfter.bo")) {	//�ۼ��Ѹ���
    	  action = new WriteAfterAction();     			
    	  
    	  try {
    		  forward = action.execute(request, response);   
    	  } catch (Exception e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
		/*else if(command.equals("/bookmark.bo")) {	//���ã�����
		  action = new BookmarkAction();     			
		  
		  try {
			  forward = action.execute(request, response);   
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		}*/
		/*else if(command.equals("/noticeWrite.bo")) {	//�������� ���ȭ��
		  action = new NoticeWriteAction();     			
		  
		  try {
			  forward = action.execute(request, response);   
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		}*/
		/*else if(command.equals("/noticeAList.bo")) {	//�������� ����Ʈ
		  action = new NoticeListAction();     			
		  
		  try {
			  forward = action.execute(request, response);   
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		}*/
      else if(command.equals("/amtmList.bo")) {	//1��1 ���ǳ��� ����Ʈ
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
      
      //3. forward ��ü�� ������ ����ؼ� ������
      if(forward != null) {
         //��ûó���� ����� ������...
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