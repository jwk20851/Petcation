package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ANoticeUpdateService;
import service.ViewANoticeWriteService;
import vo.BoardVO;

@Controller
public class ANoticeWriteController {

	
	@Autowired
	private ViewANoticeWriteService viewANoticeWriteService;
	
	@RequestMapping("/anotice_insert_action.bo")
	public String writeANotice(BoardVO boardVO) {
		viewANoticeWriteService.writeService(boardVO);
		
		return "redirect:/noticeAList.bo";
	}
}
