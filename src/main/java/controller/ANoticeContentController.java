package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ViewANoticeContentService;
import vo.BoardVO;

@Controller
public class ANoticeContentController {

	@Autowired
	private ViewANoticeContentService viewANoticeContentService;
	
	@RequestMapping("/anotice_content.bo")
	public ModelAndView showANoticeContent(@RequestParam int num) {
		ModelAndView mav = new ModelAndView();
		BoardVO boardVO = viewANoticeContentService.getANoticeContent(num);
		mav.addObject("boardVO",boardVO);
		mav.setViewName("viewANotice");
		
		return mav;
		
	}
}
