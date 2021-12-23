package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ViewANoticeContentService;
import service.ViewMTMService;
import vo.BoardVO;

@Controller
public class MTMContentController {

	@Autowired
	private ViewMTMService viewMTMService;
	
	@RequestMapping("/mtm_content.bo")
	public ModelAndView showMTMContent(@RequestParam int num) {
		ModelAndView mav = new ModelAndView();
		BoardVO boardVO = viewMTMService.getMTMContent(num);
		mav.addObject("boardVO",boardVO);
		mav.setViewName("viewMTM");
		
		return mav;
		
	}
}
