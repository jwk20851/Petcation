package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ANoticeUpdateFormService;
import service.ViewANoticeWriteService;
import vo.BoardVO;

@Controller
public class ANoticeUpdateFormController {

	@Autowired
	private ANoticeUpdateFormService aNoticeUpdateFormService;
	
	@RequestMapping("/anotice_updateForm.bo")
	public ModelAndView anoticeUpdateForm(@RequestParam int num) {
		ModelAndView mav = new ModelAndView();
		BoardVO boardVO = aNoticeUpdateFormService.getOldBoardVO(num);
		mav.setViewName("updateANotice");
		mav.addObject("boardVO", boardVO);
		
		return mav;
		
	}
}
