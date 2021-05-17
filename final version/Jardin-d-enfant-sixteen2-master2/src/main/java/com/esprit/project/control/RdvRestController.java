package com.esprit.project.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Conversation;
import com.esprit.project.entity.Message;
import com.esprit.project.entity.Rdv;
import com.esprit.project.payload.response.MessageResponse;
import com.esprit.project.service.IGestionRdv;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
public class RdvRestController {
	
	@Autowired 
	IGestionRdv gestionRdv;
	
	// http://localhost:8081/rdvs
	@GetMapping("/rdvs")
	@ResponseBody
	public List<Rdv> getRdvs() {
	List<Rdv> list = gestionRdv.retrieveAllRdvs();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-rdv/{rdv-id}
	@GetMapping("/rdvs/{rdv-id}")
	@ResponseBody
	public Optional<Rdv> retrieveRdv(@PathVariable("rdv-id") String idRdv) {
	return gestionRdv.retrieveRdv(idRdv);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-rdv
	/*@PostMapping("/rdvs")
	@ResponseBody
	public Rdv addRdv(@RequestBody Rdv rdv1) {
	Rdv rdv = gestionRdv.addRdv(rdv1);
	return rdv;
	}*/
	
	// http://localhost:8081/SpringMVC/servlet/remove-rdv/{rdv-id}
	@DeleteMapping("/rdvs/{rdv-id}")
	@ResponseBody
	public void removeRdv(@PathVariable("rdv-id") String idRdv) {
	gestionRdv.deleteRdv(idRdv);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-rdv
	@PutMapping("/rdvs")
	@ResponseBody
	public Rdv modifyRdv(@RequestBody Rdv rdv) {
	return gestionRdv.updateRdv(rdv);
	}
	
	@PostMapping("/rdvs")
	@ResponseBody
	public ResponseEntity addRdv(@RequestParam("rdvs") String rdv1, @RequestParam("user") Long userId) {
		String message = ""; 
        Rdv addRdv = new Rdv();
        try {          
          
          addRdv = new ObjectMapper().readValue(rdv1, Rdv.class);
          
          gestionRdv.store(addRdv, userId); 
          
          message = "Uploaded rdv successfully: ";
      
          return ResponseEntity.status(HttpStatus.OK).body(message);
      
      } catch (Exception e) { e.printStackTrace(); 
          message = "Could not upload the post!"; 
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message)); }

	}
	
	@GetMapping("/rdv/{rdv_id}")
	  @ResponseBody
	  public Rdv getRdvsbyId (@PathVariable Long rdv_id) {
		return gestionRdv.gestionRdv(rdv_id);
		  } 
}
