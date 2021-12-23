package controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ViewANoticeListService;

@Controller
public class ANoticeDeleteController {
	
	@Autowired
	private ViewANoticeListService viewANoticeListService;
	
	@RequestMapping("/deleteANotice.bo")
	public String deleteANotice(@RequestParam int[] delete1) {
		viewANoticeListService.removeANotice(delete1);
		
		return "redirect:/noticeAList.bo";
	}
	
	@RequestMapping(value = "/ANoticeDeleteContent.bo",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteANoticeContent(@RequestParam int num) {
		viewANoticeListService.deleteANotice(num);
		ModelAndView mav = new ModelAndView("redirect:/noticeAList.bo");
		return mav;
	}
	

}
