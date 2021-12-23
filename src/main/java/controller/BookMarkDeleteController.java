package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.BookMarkListService;



@Controller
public class BookMarkDeleteController {

	@Autowired
	private BookMarkListService bookMarkListService;
	
	@RequestMapping(value = "/bookmarkDelete.bo", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteBookmark(@RequestParam int num) {
		bookMarkListService.deleteBookmark(num);
		ModelAndView mav = new ModelAndView("redirect:/bookMark_list.bo");
		return mav;
	}
}
