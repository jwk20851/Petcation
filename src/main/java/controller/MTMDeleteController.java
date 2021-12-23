package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ViewMTMService;

@Controller
public class MTMDeleteController {
	@Autowired
	private ViewMTMService viewMTMService;
	
	@RequestMapping(value = "/MTMDelete.bo", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteMTM(@RequestParam int num) {
		viewMTMService.deleteMTM(num);
		ModelAndView mav = new ModelAndView("redirect:/viewMTMList.bo");
		return mav;
	}

}
