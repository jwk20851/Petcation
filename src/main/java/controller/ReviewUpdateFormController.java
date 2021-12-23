package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ManageReviewListService;
import vo.BoardVO;

@Controller
public class ReviewUpdateFormController {
	
	@Autowired
	private ManageReviewListService manageReviewListService;
	
	@RequestMapping("/boardUpdateForm.bo")
	public ModelAndView reviewUpdateForm(@RequestParam int num) {
		ModelAndView mav = new ModelAndView();
		BoardVO boardVO = manageReviewListService.getOldBoardVO(num);
		mav.setViewName("updateReview");
		mav.addObject("boardVO", boardVO);
		
		return mav;
	}
	
	@RequestMapping("/boardUpdatePro.bo")
	public String updateANotice(BoardVO boardVO) {
		manageReviewListService.modifyBoard(boardVO);
		
		return "redirect:/writeAfter.bo";
	}
}
