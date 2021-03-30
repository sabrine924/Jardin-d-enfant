package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Email;


public interface IGestionMailing {
	
	List<Email> retrieveAllEmails();
	Email addEmail(Email email);
	void deleteEmail(String id);
	Email updateEmail(Email email);
	Optional<Email> retrieveEmail(String id);
	List<String> sendEmail();

}
