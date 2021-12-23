package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.FAQDAO;
import vo.BoardVO;
import vo.FAQVO;

@Service
public class FAQService {
	
	@Autowired
	private FAQDAO fAQDAO;
	//list
	public List<FAQVO> getFAQList() {
		List<FAQVO> viewFAQList = fAQDAO.selectFAQList();
		
		return viewFAQList;
	}
	//페이징 작업
	public List<FAQVO> getArticleList(int startRow, int pageSize) {
		
		List<FAQVO> articleList = fAQDAO.selectArticleList(startRow, pageSize);
		return articleList;
	}
	
	

}
