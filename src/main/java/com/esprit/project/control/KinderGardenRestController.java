package com.esprit.project.control;

/*import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;*/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.esprit.project.entity.Account;
//import com.esprit.project.entity.Administrator;
//import com.esprit.project.entity.Delegate;
//import com.esprit.project.entity.Inscription;
import com.esprit.project.entity.KinderGarden;
//import com.esprit.project.entity.User;
//import com.esprit.project.service.IAccountService;
//import com.esprit.project.service.IAdministratorService;
//import com.esprit.project.service.IDelegateService;
//import com.esprit.project.service.IInscriptionService;
//import com.esprit.project.service.IUserService;
import com.esprit.project.service.IKinderGardenService;



@RestController
public class KinderGardenRestController {
	
	@Autowired 
	IKinderGardenService kinderGardenService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-kindergardens
	@GetMapping("/retrieve-all-kindergardens")
	@ResponseBody
	public List<KinderGarden> getKinderGarden() {
	List<KinderGarden> list = kinderGardenService.retrieveAllKinderGardens();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-Kindergarden/{Kindergarden-id}
	@GetMapping("/retrieve-Kindergarden/{Kindergarden-id}")
	@ResponseBody
	public Optional<KinderGarden> retrieveKinderGarden(@PathVariable("Kindergarden-id") String kinderGardenId) {
	return kinderGardenService.retrieveKinderGarden(kinderGardenId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-kindergarden
	@PostMapping("/add-kindergarden")
	@ResponseBody
	public KinderGarden addKinderGarden(@RequestBody KinderGarden kinderGarden1) {
	KinderGarden kinderGarden = kinderGardenService.addKinderGarden(kinderGarden1);
	return kinderGarden;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-kindergarden/{kindergarden-id}
	@DeleteMapping("/remove-kindergarden/{kindergarden-id}")
	@ResponseBody
	public void removeKinderGarden(@PathVariable("kindergarden-id") String kinderGardenId) {
		kinderGardenService.deleteKinderGarden(kinderGardenId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-kindergarden
	@PutMapping("/modify-kindergarden")
	@ResponseBody
	public KinderGarden modifyKinderGarden(@RequestBody KinderGarden kinderGarden) {
	return kinderGardenService.updateKinderGarden(kinderGarden);
	}
	
	
}
