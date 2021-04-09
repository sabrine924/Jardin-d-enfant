package com.esprit.project.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Reclamation;
import com.esprit.project.service.IReclamationService;

@RestController
public class ReclamationRestController {
	
	@Autowired
	IReclamationService reclamationService;
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-reclamations
	@GetMapping("/retrieve-all-reclamations")
	@ResponseBody
	public List<Reclamation> getReclamations() {
	List<Reclamation> Reclamation = reclamationService.retrieveAllReclamations();
	return Reclamation;
	}
	
	

	//http://localhost:8081/SpringMVC/servlet/add-reclamation
	@PostMapping("/add-reclamation")
	@ResponseBody
	public Reclamation addReclamation(@RequestBody Reclamation r) {
	Reclamation reclamation = reclamationService.addReclamation(r);
	return reclamation;
	}
	// http://localhost:8081/SpringMVC/servlet/modify-reclamation
		@PutMapping("/modify-reclamation")
		@ResponseBody
		public Reclamation modifyReclamation(@RequestBody Reclamation reclamation) {
		return reclamationService.updateReclamation(reclamation);
		}
		// http://localhost:8081/SpringMVC/servlet/remove-reclamation/{reclamation-id}
		@DeleteMapping("/remove-reclamation/{reclamation-id}")
		@ResponseBody
		public void removeReclamation(@PathVariable("reclamation-id") String id) {
			reclamationService.deleteReclamationById(id);
		} 
	}


