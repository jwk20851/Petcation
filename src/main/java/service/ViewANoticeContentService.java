package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ViewANoticeDAO;
import vo.BoardVO;

@Service
public class ViewANoticeContentService {

	@Autowired
	private ViewANoticeDAO viewANoticeDAO;

	public BoardVO getANoticeContent(int num) {
		BoardVO boardVO = viewANoticeDAO.selectANoticeVO(num);
		return boardVO;
	}
	
	

}
