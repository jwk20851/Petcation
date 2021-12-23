package controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.AFAQService;
import service.ViewANoticeListService;

@Controller
public class AFAQDeleteController {
	
	@Autowired
	private AFAQService aFAQService;
	
	@RequestMapping("/deleteAFAQ.bo")
	public String deleteAFAQ(@RequestParam int[] delete1) {
		aFAQService.removeAFAQ(delete1);
		
		return "redirect:/afaqList.bo";
	}
	
}
