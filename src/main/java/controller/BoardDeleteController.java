package controller;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.BoardDeleteProService;
import service.ManageReviewListService;
import vo.BoardVO;

@Controller
public class BoardDeleteController {

	@Autowired
	private ManageReviewListService manageReviewListService;
	
	/*@RequestMapping("/boardDeleteForm.bo")
	public ModelAndView removeReviewForm(@RequestParam int num) {
		ModelAndView mav = new ModelAndView();
		BoardVO boardVO = manageReviewListService.getReviewDelete(num);
		mav.addObject("boardVO", boardVO);
		mav.setViewName("deleteForm");
		
		return mav;
	}*/
	
	@RequestMapping(value = "/boardDeleteForm.bo", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView removeBoard(@RequestParam int num) {
		manageReviewListService.removeReview(num);
		ModelAndView mav = new ModelAndView("redirect:/writeAfter.bo");
		return mav;
	}
	
	
}
