package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ViewAMTMService;
import vo.BoardVO;

@Controller
public class AMTMUpdateController {

	@Autowired
	private ViewAMTMService viewAMTMService;

	@RequestMapping("/amtm_updateForm.bo")
	public ModelAndView amtmUpdateForm(@RequestParam int num) {
		ModelAndView mav = new ModelAndView();
		BoardVO boardVO = viewAMTMService.getOldBoardVO(num);
		mav.addObject("boardVO", boardVO);
		mav.setViewName("updateAMTM");

		return mav;

	}

	@RequestMapping("/amtm_update_action.bo")
	public String updateAMTM(BoardVO boardVO) {
		System.out.println("들어옴");
		
		viewAMTMService.modifyBoard(boardVO);

		return "redirect:/amtmList.bo";
	}
}
