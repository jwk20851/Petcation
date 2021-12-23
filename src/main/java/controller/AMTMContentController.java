package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ViewAMTMService;
import vo.BoardVO;

@Controller
public class AMTMContentController {
	@Autowired
private ViewAMTMService viewAMTMService;
	
	@RequestMapping("/amtm_content.bo")
	public ModelAndView showAMTMContent(@RequestParam int num) {
		ModelAndView mav = new ModelAndView();
		BoardVO boardVO = viewAMTMService.getAMTMContent(num);
		mav.addObject("boardVO",boardVO);
		mav.setViewName("viewAMTM");
		
		return mav;
		
	}
}
