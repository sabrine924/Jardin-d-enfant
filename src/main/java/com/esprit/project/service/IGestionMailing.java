package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Email;
import com.esprit.project.entity.User;


public interface IGestionMailing {
	
	List<Email> retrieveAllEmails();
	Optional<Email> retrieveEmail(String id);
	public void sendmail(User user);

}
