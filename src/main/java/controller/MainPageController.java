package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.MainPageService;
import vo.BoardVO;
import vo.FAQVO;
import vo.PetVO;

@Controller
public class MainPageController {
	@Autowired
	private MainPageService mainPageService;
	
	@RequestMapping("/mainPage.pets")
	public ModelAndView viewMainPage() {
		ModelAndView mav = new ModelAndView();
		System.out.println("hello");
		
		return mav;
	}
}
