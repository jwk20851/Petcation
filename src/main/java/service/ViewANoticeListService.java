package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ViewANoticeDAO;
import vo.BoardVO;

@Service
public class ViewANoticeListService {

	@Autowired
	private ViewANoticeDAO viewANoticeDAO;
	//list
	public List<BoardVO> getviewANoticeList() {
		List<BoardVO> viewANoticeList = viewANoticeDAO.selectViewANoticeList();
		
		return viewANoticeList;
	}
	//게시글 여러개 삭제
	public void removeANotice(int[] delete1) {
		viewANoticeDAO.deleteANotice(delete1);
		
	}
	//게시글 내용삭제
	public void deleteANotice(int num) {
		viewANoticeDAO.deleteANoticeContent(num);
		
	}
	public List<BoardVO> getArticleList(int startRow, int pageSize) {
		List<BoardVO> articleList = viewANoticeDAO.selectArticleList(startRow, pageSize);
		return articleList;
	}

}
