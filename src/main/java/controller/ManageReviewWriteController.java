package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ManageReviewListService;
import vo.BoardVO;

@Controller
public class ManageReviewWriteController {
	@Autowired
	private ManageReviewListService manageReviewListService;
	
	
	@RequestMapping("/boardWritePro.bo")
	public String writeReview(BoardVO boardVO) {
		manageReviewListService.writeService(boardVO);
		return "redirect:/writeAfter.bo";
	}
}
