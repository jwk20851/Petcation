package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.PetregistService;
import vo.ActionForward;
import vo.PetVO;
import vo.UserVO;

public class petinsertaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("userVO"); 
		String user_Id = userVO.getUser_id();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String kind = request.getParameter("kind");
		String detailkind = request.getParameter("detailkind");
		String gender = request.getParameter("gender");
		String weight = request.getParameter("weight");
		String disease = request.getParameter("disease");
		String detailinfo = request.getParameter("detailinfo");
		String filename = request.getParameter("filename");
		PetVO petVO = new PetVO();
		petVO.setUser_Id(user_Id);
		petVO.setPet_Age(Integer.parseInt(age));
		petVO.setPet_Breed(detailkind);
		petVO.setPet_Disease(disease);
		petVO.setPet_Gender(gender);
		petVO.setPet_Infodetail(detailinfo);
		petVO.setPet_Kind(kind);
		petVO.setPet_Name(name);
		petVO.setPet_Weight(Integer.parseInt(weight));
		petVO.setPet_Filename(filename);

		PetregistService petregistService = new PetregistService();
		boolean registSuccess = petregistService.registPet(petVO);

		ActionForward forward = null;
		if (registSuccess) {
			forward = new ActionForward();
			forward.setUrl("../petInfo_list.pets");
			forward.setRedirect(true);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("<script>");

		}
		return forward;
	}

}
