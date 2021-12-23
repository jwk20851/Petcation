package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.AFAQService;
import service.ManageReviewListService;
import vo.BoardVO;
import vo.FAQVO;

@Controller
public class AFAQUpdateFormController {
	
	@Autowired
	private AFAQService aFAQService;
	
	@RequestMapping("/afaq_updateForm.bo")
	public ModelAndView reviewUpdateForm(@RequestParam int num) {
		ModelAndView mav = new ModelAndView();
		FAQVO faqVO = aFAQService.getOldFAQVO(num);
		mav.setViewName("updateAFAQ");
		mav.addObject("faqVO", faqVO);
		
		return mav;
	}
	
	@RequestMapping("/afaq_update_action.bo")
	public String updateANotice(FAQVO faqVO) {
		aFAQService.modifyBoard(faqVO);
		
		return "redirect:/afaqList.bo";
	}
}
