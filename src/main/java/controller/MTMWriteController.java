package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ViewMTMService;
import vo.BoardVO;

@Controller
public class MTMWriteController {

	@Autowired
	private ViewMTMService viewMTMService;
	
	@RequestMapping("/mtm_insert_action.bo")
	public String writeANotice(BoardVO boardVO) {
		viewMTMService.writeService(boardVO);
		
		return "redirect:/viewMTMList.bo";
	}
	
}
