package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AFAQDAO;
import dao.FAQDAO;
import vo.FAQVO;

@Service
public class AFAQService {
	
	@Autowired
	private AFAQDAO aFAQDAO;
	
	//list
	public List<FAQVO> getAFAQList() {
		List<FAQVO> viewAFAQList = aFAQDAO.selectAFAQList();
		
		return viewAFAQList;
	}
	
	//write
	public void writeService(FAQVO faqVO) {
		aFAQDAO.insertAFAQ(faqVO);
		
	}
	//게시글 여러개 삭제
	public void removeAFAQ(int[] delete1) {
		aFAQDAO.deleteAFAQ(delete1);
		
	}
	//수정전 글 불러오기
	public FAQVO getOldFAQVO(int num) {
		FAQVO faqVO = aFAQDAO.selectOldFAQVO(num);
		return faqVO;
	}
	//수정후 저장하기
	public void modifyBoard(FAQVO faqVO) {
		aFAQDAO.updateAFAQ(faqVO);
		
	}
	//페이징처리
	public List<FAQVO> getArticleList(int startRow, int pageSize) {
		List<FAQVO> articleList = aFAQDAO.selectArticleList(startRow, pageSize);
		return articleList;
	}

}
