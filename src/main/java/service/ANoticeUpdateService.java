package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ViewANoticeDAO;
import vo.BoardVO;

@Service
public class ANoticeUpdateService {

	@Autowired
	private ViewANoticeDAO viewANoticeDAO;

	public void modifyBoard(BoardVO boardVO) {
		viewANoticeDAO.updateANotice(boardVO);
		
	}
	
}
