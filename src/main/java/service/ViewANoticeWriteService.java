package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ViewANoticeDAO;
import vo.BoardVO;

@Service
public class ViewANoticeWriteService {

	@Autowired
	private ViewANoticeDAO viewANoticeDAO;
	
	//write
	public void writeService(BoardVO boardVO) {
		viewANoticeDAO.insertANotice(boardVO);
	}
}
