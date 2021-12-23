package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.AFAQService;
import vo.FAQVO;

@Controller
public class AFAQWriteController {

	@Autowired
	private AFAQService aFAQService;
	
	@RequestMapping("/afaq_insert_action.bo")
	public String writeAFAQ(FAQVO fAQVO) {
		aFAQService.writeService(fAQVO);
		
		return "redirect:/afaqList.bo";
	}
}
