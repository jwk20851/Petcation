package controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.PetInfoRemoveService;

@Controller
public class PetInfoRemoveController {
	
	@Autowired
	private PetInfoRemoveService petInfoRemoveService;
	
	@RequestMapping("/petInfo_remove.pets")
	public String removePetInfo(@RequestParam String[] delete1) {
		//System.out.println(Arrays.toString(delete1)); //16,14
		
		petInfoRemoveService.removePetInfo(delete1);
		
		return "redirect:/petInfo_list.pets";
	}
}
