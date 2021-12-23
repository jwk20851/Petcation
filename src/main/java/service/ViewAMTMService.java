package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ViewAMTMDAO;
import dao.ViewMTMDAO;
import vo.BoardVO;
import vo.FAQVO;

@Service
public class ViewAMTMService {
	@Autowired
	private ViewAMTMDAO viewAMTMDAO;
	
	//상세조회
	public BoardVO getAMTMContent(int num) {
		BoardVO boardVO = viewAMTMDAO.selectAMTMVO(num);
		return boardVO;
	}
	
	//list
	public List<BoardVO> getAMTMList() {
		List<BoardVO> viewAMTMList = viewAMTMDAO.selectAMTMList();
		return viewAMTMList;
	}
	//수정전 불러오기
	public BoardVO getOldBoardVO(int num) {
		BoardVO boardVO = viewAMTMDAO.selectOldBoardVO(num);
		return boardVO;
	}
	//수정후 저장
	public void modifyBoard(BoardVO boardVO) {
		viewAMTMDAO.updateAMTM(boardVO);
		
	}
	//삭제
	public void removeAMTM(int[] delete1) {
		viewAMTMDAO.deleteAMTM(delete1);
		
	}

	public List<BoardVO> getArticleList(int startRow, int pageSize) {
		List<BoardVO> articleList = viewAMTMDAO.selectArticleList(startRow, pageSize);
		return articleList;
	}

	

}
