package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ViewMTMDAO;
import vo.BoardVO;
@Service
public class ViewMTMService {

	@Autowired
	private ViewMTMDAO viewMTMDAO;
	
	//글쓰기
	public void writeService(BoardVO boardVO) {
		viewMTMDAO.insertANotice(boardVO);
	}
	
	//list목록
	public List<BoardVO> getMTMList() {
		List<BoardVO> viewMTMList = viewMTMDAO.selectViewMTMList();
		
		return viewMTMList;
	}
	//조회
	public BoardVO getMTMContent(int num) {
		BoardVO boardVO = viewMTMDAO.selectMTMVO(num);
		return boardVO;
	}
	//삭제
	public void deleteMTM(int num) {
		viewMTMDAO.deleteMTM(num);
		
	}

	public List<BoardVO> getArticleList(int startRow, int pageSize) {
		List<BoardVO> articleList = viewMTMDAO.selectArticleList(startRow, pageSize);
		return articleList;
	}

}
