package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AMTMDAO;
import vo.BoardVO;

@Service
public class AMTMListService {
	
	@Autowired
	private AMTMDAO aMTMDAO;

	public List<BoardVO> getAMTMList() {
		List<BoardVO> viewAMTMList = aMTMDAO.selectAMTMList();
		return viewAMTMList;
	}

}
