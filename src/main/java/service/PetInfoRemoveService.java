package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PetDAO;

@Service
public class PetInfoRemoveService {
	@Autowired
	private PetDAO petDAO;
	
	public void removePetInfo(String[] delete1) {
		
		petDAO.deletePetInfo(delete1);
		
	}

}
