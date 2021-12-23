package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ViewANoticeDAO;
import vo.BoardVO;

@Service
public class ANoticeUpdateFormService {

	@Autowired
	private ViewANoticeDAO viewANoticeDAO;

	public BoardVO getOldBoardVO(int num) {
		BoardVO boardVO = viewANoticeDAO.selectOldBoardVO(num);
		return boardVO;
	}
	
	
}
