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
//import com.esprit.project.entity.Parent;
import com.esprit.project.entity.Profile;
//import com.esprit.project.entity.User;
//import com.esprit.project.service.IAccountService;
//import com.esprit.project.service.IAdministratorService;
//import com.esprit.project.service.IDelegateService;
//import com.esprit.project.service.IInscriptionService;
//import com.esprit.project.service.IUserService;
//import com.esprit.project.service.IKinderGardenService;
//import com.esprit.project.service.IParentService;
import com.esprit.project.service.IProfileService;



@RestController
public class ProfileRestController {
	
	@Autowired 
	IProfileService profileService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-profiles
	@GetMapping("/retrieve-all-profiles")
	@ResponseBody
	public List<Profile> getProfile() {
	List<Profile> list = profileService.retrieveAllProfiles();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-profile/{profile-id}
	@GetMapping("/retrieve-profile/{profile-id}")
	@ResponseBody
	public Optional<Profile> retrieveProfile(@PathVariable("profile-id") String profileId) {
	return profileService.retrieveProfile(profileId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-profile
	@PostMapping("/add-profile")
	@ResponseBody
	public Profile addProfile(@RequestBody Profile profile1) {
	Profile profile = profileService.addProfile(profile1);
	return profile;
	}
	
	// http://localhost:8081/SpringMVC/servlet/remove-profile/{profile-id}
	@DeleteMapping("/remove-profile/{profile-id}")
	@ResponseBody
	public void removeProfile(@PathVariable("profile-id") String profileId) {
		profileService.deleteProfile(profileId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/modify-profile
	@PutMapping("/modify-profile")
	@ResponseBody
	public Profile modifyProfile(@RequestBody Profile profile) {
	return profileService.updateProfile(profile);
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
