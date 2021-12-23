package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BookMarkListService;
import vo.UserVO;

@Controller
public class BookMarkRegistController {
   @Autowired
   private BookMarkListService bookMarkListService;
   
   @RequestMapping("/bookMark_regist.bo")
   public String registBookMark(HttpServletRequest request) {
      HttpSession session = request.getSession();
      UserVO userVO = (UserVO)session.getAttribute("userVO");
      
      String name = request.getParameter("name");
      String addr = request.getParameter("addr");
      String tel = request.getParameter("tel");
      
      bookMarkListService.registBookmark(userVO.getUser_id(), name, addr, tel);
      
      return "redirect:/bookMark_list.bo";
   }
   
}