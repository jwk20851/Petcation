package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PetDAO;
import vo.PetVO;

@Service
public class PetInfoListService {
	@Autowired
	private PetDAO petDAO;
	
	/*public List<PetVO> getPetInfoList() {
		// TODO Auto-generated method stub
		List<PetVO> petInfoList = petDAO.selectBoardList();
		System.out.println("서비스:"+petInfoList);
		return petInfoList;
	}*/
	
	public List<PetVO> getPetInfoList(String uid) {
		// TODO Auto-generated method stub
		System.out.println("service: "+ uid);
		List<PetVO> petInfoList = petDAO.selectBoardList(uid);
		System.out.println("서비스:"+petInfoList);
		return petInfoList;
	}

}
