package com.esprit.project.control;

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
	@GetMapping("/retrieve-all-accounts")
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
	
	// http://localhost:8081/SpringMVC/servlet/add-email
	@PostMapping("/add-email")
	@ResponseBody
	public Email addEmail(@RequestBody Email email1) {
	Email email = gestionMailing.addEmail(email1);
	return email;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-email/{email-id}
	@DeleteMapping("/remove-email/{email-id}")
	@ResponseBody
	public void removeEmail(@PathVariable("email-id") String emailId) {
	gestionMailing.deleteEmail(emailId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-email
	@PutMapping("/modify-email")
	@ResponseBody
	public Email modifyEmail(@RequestBody Email email) {
	return gestionMailing.updateEmail(email);
	}
	
	/*
	/ http://localhost:8081/SpringMVC/servlet/retrive-user-jpql/{d1}/{d2}
	@GetMapping("/retrive-user-jpql/{d1}/{d2}")
	@ResponseBody
	public List<User> retrieveUserbybirthdate(@PathVariable("d1") String d1,@PathVariable("d2") String d2) throws ParseException {
	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d1);  
	Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(d2);
	return userService.retrieveUsersByBirthDate(date1, date2);
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrive-user-sql/{date1}/{date2}
	@GetMapping("retrive-user-sql/{date1}/{date2}")
	@ResponseBody
	public List<User> retrieveUserbybirthdateSql(@PathVariable("date1") String d1,@PathVariable("date2") String d2) throws ParseException {
	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d1);  
	Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(d2);
	return userService.retrieveUsersByBirthDatesql(date1, date2);
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-user-role/{role}
	@GetMapping("/retrieve-user-role/{role}")
	@ResponseBody
	public List<User> retrieveUserbybirthdateRole(@PathVariable("role") Role role) {
	return userService.retrieveUsersByRole(role);
		}*/
}
