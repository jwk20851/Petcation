package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HosReviewDAO;
import vo.BoardVO;
import vo.ReserveVO;
@Service
public class HosReviewListService {
	@Autowired
	private HosReviewDAO hosReviewDAO;

	public List<ReserveVO> getHosReviewList() {
		List<ReserveVO> viewHosReviewList = hosReviewDAO.selectHosReviewList();
		return viewHosReviewList;
	}

	public List<ReserveVO> getArticleList(int startRow, int pageSize) {
		List<ReserveVO> articleList = hosReviewDAO.selectArticleList(startRow, pageSize);
		return articleList;
	}

}
