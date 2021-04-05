package com.esprit.project.control;

/*import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;*/
//import java.util.List;
/*import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Account;
//import com.esprit.project.entity.User;
import com.esprit.project.service.IAccountService;
//import com.esprit.project.service.IUserService;



@RestController
public class AccountRestController {
	
	@Autowired 
	IAccountService accountService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-accounts
	@GetMapping("/retrieve-all-accounts")
	@ResponseBody
	public List<Account> getAccounts() {
	List<Account> list = accountService.retrieveAllAccounts();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-account/{account-id}
	@GetMapping("/retrieve-account/{account-id}")
	@ResponseBody
	public Optional<Account> retrieveAccount(@PathVariable("account-id") String accountId) {
	return accountService.retrieveAccount(accountId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-account
	@PostMapping("/add-account")
	@ResponseBody
	public Account addAccount(@RequestBody Account account1) {
	Account account = accountService.addAccount(account1);
	return account;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-account/{account-id}
	@DeleteMapping("/remove-account/{account-id}")
	@ResponseBody
	public void removeAccount(@PathVariable("account-id") String accountId) {
	accountService.deleteAccount(accountId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-account
	@PutMapping("/modify-account")
	@ResponseBody
	public Account modifyAccount(@RequestBody Account account) {
	return accountService.updateAccount(account);
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
//}
