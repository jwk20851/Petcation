package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ManageReviewDAO;
import vo.BoardVO;

@Service
public class ManageReviewListService {
	@Autowired
	private  ManageReviewDAO manageReviewDAO;
	//list 보기
	public List<BoardVO> getmanageReviewList() {
		List<BoardVO> manageReviewList = manageReviewDAO.selectmanageReviewList();
		
		return manageReviewList;
	}
	
	//글쓰기
	public void writeService(BoardVO boardVO) {
		manageReviewDAO.insertReview(boardVO);
		
	}
	//작성한 리뷰 list
	public List<BoardVO> getReviewWrittenList() {
		List<BoardVO> manageWrittenReview = manageReviewDAO.selectReviewWrittenList();
		
		return manageWrittenReview;
	}
	//리뷰수정
	public BoardVO getOldBoardVO(int num) {
		BoardVO boardVO = manageReviewDAO.selectOldBoardVO(num);
		return boardVO;
	}

	public void modifyBoard(BoardVO boardVO) {
		manageReviewDAO.updateANotice(boardVO);
		
	}
	
	//삭제action
	public void removeReview(int num) {
		manageReviewDAO.deleteReview(num);
		
	}

	public List<BoardVO> getArticleList(int startRow, int pageSize) {
		List<BoardVO> articleList = manageReviewDAO.selectArticleList(startRow, pageSize);
		return articleList;
	}

	

}
