package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.AFAQService;
import vo.FAQVO;
import vo.PageVO;

@Controller
public class AFAQListController {
	
	@Autowired
	private AFAQService aFAQService;
	
	@RequestMapping("/afaqList.bo")
	public ModelAndView FAQList(HttpServletRequest request) {
		List<FAQVO> viewAFAQList = aFAQService.getAFAQList();
		
		int pageSize = 5;	//한페이지당 나오는 글 수
		PageVO pageVO = new PageVO();
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		
		int totalCount = viewAFAQList.size();
		int number = 0;
		
		List<FAQVO> articleList = null;
		
		if(totalCount > 0) {
			articleList = aFAQService.getArticleList(startRow, pageSize);
		}
		number = totalCount - (currentPage - 1) * pageSize;
		
		int pageCount = 0;		//총 페이지의 개수
		int startPage = 0;		//동일 페이지 그룹에서 첫 페이지 번호
		int endPage = 0;
		
		if(totalCount > 0) {
			pageCount = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
			//글 : 132
			
			startPage = (int)((currentPage - 1)/ 10) * 10 + 1;
			//현재 페이지 1 (1 - 1) / 10 * 10 + 1 : 1
			//현재 페이지 7 (7 - 1) / 10 * 10 + 1 : 1
			
			endPage = startPage + 9;
			
			//마지막 페이지 그룹일때
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		pageVO.setCount(totalCount);					//13. vo에서 선언한 것 넣음.
		pageVO.setCurrentPage(currentPage);
		pageVO.setEndPage(endPage);
		pageVO.setNumber(number);
		pageVO.setPageCount(pageCount);
		pageVO.setStartPage(startPage);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewAFAQList");
		mav.addObject("viewAFAQList", viewAFAQList);
		mav.addObject("articleList", articleList);
		mav.addObject(pageVO);
		return mav;
	}
}
