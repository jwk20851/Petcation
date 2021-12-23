package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PetDAO;
import vo.PetVO;

@Service
public class PetInfoSaveService {
	@Autowired
	private PetDAO petDAO;
	public void saveService(PetVO petVO) {
		// TODO Auto-generated method stub
		petDAO.insertPet(petVO);
	}

}
