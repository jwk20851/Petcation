package action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import service.FindIdService;
import service.FindPwService;
import vo.ActionForward;

import vo.UserVO;

public class FindPwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		char pwCollection[] = new char[] {
	              '1','2','3','4','5','6','7','8','9','0',
	              'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
	              'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
	              };//배열에 선언

		  	String ranPw = "";

		  	for (int i = 0; i < 10; i++) {
		  		int selectRandomPw = (int)(Math.random()*(pwCollection.length));//Math.rondom()은 0.0이상 1.0미만의 난수를 생성해 준다.
		  		ranPw += pwCollection[selectRandomPw];
		  	}
		  	
		
		
		
		FindPwService findPwService = new FindPwService();
		UserVO selectinfo = findPwService.getUserInfo(id, email);
		selectinfo.setUser_pw(ranPw);
		boolean findPw = findPwService.getFindPw(selectinfo);
		
		
		ActionForward forward = null;
		forward = new ActionForward();
		HttpSession session = request.getSession();
		
		if(findPw) {
			
			session.setAttribute("userVO", selectinfo);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("인증성공!");
			forward.setUrl("comppw.jsp");
			forward.setRedirect(true);

			
		}
		else {
				session.setAttribute("userVO", null);
				
				System.out.println("인증실패!");
				forward.setUrl("comppw.jsp");
				forward.setRedirect(true);

				
		}
		
		return forward;
	}

}
