package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.ViewAMTMService;

@Controller
public class AMTMDeleteController {
	@Autowired
	private ViewAMTMService viewAMTMService;
	
	@RequestMapping("/deleteAMTM.bo")
	public String deleteAMTM(@RequestParam int[] delete1) {
		viewAMTMService.removeAMTM(delete1);
		
		return "redirect:/amtmList.bo";
	}
}
