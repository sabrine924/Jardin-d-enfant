package com.esprit.project.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Email;
import com.esprit.project.service.IGestionMailing;


/*import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;*/


@RestController
public class EmailRestController {
	
	@Autowired 
	IGestionMailing gestionMailing;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-emails
	@GetMapping("/retrieve-all-emails")
	@ResponseBody
	public List<Email> getEmails() {
	List<Email> list = gestionMailing.retrieveAllEmails();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-email/{email-id}
	@GetMapping("/retrieve-email/{email-id}")
	@ResponseBody
	public Optional<Email> retrieveEmail(@PathVariable("email-id") String emailId) {
	return gestionMailing.retrieveEmail(emailId);
	}
	
	
	// http://localhost:8081/SpringMVC/servlet/send-email
	@PostMapping("/send-email/{user_id}")
	@ResponseBody
	public void sendmail(@PathVariable("user_id") Long user_id){
		sendmail(user_id);
	    
	}
	
}
