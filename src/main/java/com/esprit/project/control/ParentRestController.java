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
//import com.esprit.project.entity.KinderGarden;
import com.esprit.project.entity.Parent;
//import com.esprit.project.entity.User;
//import com.esprit.project.service.IAccountService;
//import com.esprit.project.service.IAdministratorService;
//import com.esprit.project.service.IDelegateService;
//import com.esprit.project.service.IInscriptionService;
//import com.esprit.project.service.IUserService;
//import com.esprit.project.service.IKinderGardenService;
import com.esprit.project.service.IParentService;



@RestController
public class ParentRestController {
	
	@Autowired 
	IParentService parentService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-parents
	@GetMapping("/retrieve-all-parents")
	@ResponseBody
	public List<Parent> getParent() {
	List<Parent> list = parentService.retrieveAllParents();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-parent/{parent-id}
	@GetMapping("/retrieve-parent/{parent-id}")
	@ResponseBody
	public Optional<Parent> retrieveParent(@PathVariable("parent-id") String parentId) {
	return parentService.retrieveParent(parentId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-parent
	@PostMapping("/add-parent")
	@ResponseBody
	public Parent addParent(@RequestBody Parent parent1) {
	Parent parent = parentService.addParent(parent1);
	return parent;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-parent/{parent-id}
	@DeleteMapping("/remove-parent/{parent-id}")
	@ResponseBody
	public void removeParent(@PathVariable("parent-id") String parentId) {
		parentService.deleteParent(parentId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-parent
	@PutMapping("/modify-parent")
	@ResponseBody
	public Parent modifyParent(@RequestBody Parent parent) {
	return parentService.updateParent(parent);
	}
	
	
}
