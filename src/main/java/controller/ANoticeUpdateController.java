package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ANoticeUpdateService;
import service.ViewANoticeWriteService;
import vo.BoardVO;

@Controller
public class ANoticeUpdateController {


	@Autowired
	private ANoticeUpdateService aNoticeUpdateService;
	
	@RequestMapping("/anotice_update_action.bo")
	public String updateANotice(BoardVO boardVO) {
		aNoticeUpdateService.modifyBoard(boardVO);
		
		return "redirect:/noticeAList.bo";
	}
}
