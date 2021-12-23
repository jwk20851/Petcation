package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.CancelStopAction;
import action.CheckOlIdAction;
import action.CheckPwAction;
import action.FindIdAction;
import action.FindPwAction;
import action.FintreatAction;
import action.JoinAction;
import action.LoginAction;
import action.LogoutAction;
import action.MailidentiAction;
import action.ViewReserveListAction;
import action.ViewReserverAction;
import action.WatchmgHosInfoAction;
import action.cancelresvaction;
import action.checkUserInfoAction;
import action.checkhosppwaction;
import action.deleteUserInfoAction;
import action.deletehospInfoaction;
import action.findpetNameaction;
import action.findselfresvaction;
import action.petinsertaction;
import action.reservationaction;
import action.searchHospaction;
import action.systemUpdateAction;
import action.updateUserInfoAction;
import action.updatehospInfoaction;
import action.watchHosRsvaction;
import vo.ActionForward;



/**
 * Servlet implementation class SendMailTest
 */
@WebServlet("*.pet")
public class PetcationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetcationController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String requestURI = request.getRequestURI();
		
		
		String contextPath = request.getContextPath();
		
		
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("command = " + command);
		
	
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/mailidenti.pet")) {
			action = new MailidentiAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/join.pet")) {
			action = new JoinAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/login.pet")) {
			action = new LoginAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/logout.pet")) {
			action = new LogoutAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/checkpw.pet")) {
			action = new CheckPwAction();
			
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/findid.pet")) {
			action = new FindIdAction();
			
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/findpw.pet")) {
			action = new FindPwAction();
			
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/checkolid.pet")) {
		
			action = new CheckOlIdAction();
			
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/updateuserinfo.pet")) {
			action = new updateUserInfoAction();
			
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/checkUser.pet")) {
			action = new checkUserInfoAction();
			
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/deleteuserinfo.pet")) {
			action = new deleteUserInfoAction();
			
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/systemupdate.pet")) {
			action = new systemUpdateAction();
			
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
		else if (command.equals("/checkhosppw.pet")) {
	         action = new checkhosppwaction();
	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/board/save.pet")) {
	         action = new petinsertaction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      } 
		 else if (command.equals("/updatehospInfo.pet")) {
	         action = new updatehospInfoaction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/deletehospInfo.pet")) {
	         action = new deletehospInfoaction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/searchHosp.pet")) {
	         action = new searchHospaction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/watchhosrsv.pet")) {
	         action = new watchHosRsvaction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/findpetName.pet")) {
	         action = new findpetNameaction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/reservation.pet")) {
	         action = new reservationaction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/findselfresv.pet")) {
	         action = new findselfresvaction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/cancelresv.pet")) {
	         action = new cancelresvaction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/viewresv.pet")) {
	         action = new ViewReserveListAction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/viewResver.pet")) {
	         action = new ViewReserverAction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/watchmgHosInfo.pet")) {
	         action = new WatchmgHosInfoAction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/cancelstop.pet")) {
	         action = new CancelStopAction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		 else if (command.equals("/fintreat.pet")) {
	         action = new FintreatAction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
		
		
		
		
		
		if(forward != null) {
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
