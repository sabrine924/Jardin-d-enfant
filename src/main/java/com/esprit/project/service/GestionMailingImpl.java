package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.project.entity.Email;

import org.springframework.stereotype.Service;
@Service
public class GestionMailingImpl implements IGestionMailing{

		@Autowired 
		EmailRepository emailRepository;
		private static final Logger l = LogManager.getLogger(GestionMailingImpl.class);
		@Override
		public List<Email> retrieveAllEmails() {
			List<Email> emails = (List<Email>) emailRepository.findAll();
			for (Email email : emails){
				l.info("Email :" + email);
			}
			return emails;
			}

		@Override
		public Email addEmail(Email email) {
			return emailRepository.save(email);
		}

		@Override
		public void deleteEmail(String idemail) {
			long id1 = Long.parseLong(idemail);
			emailRepository.deleteById(id1);
		}

		@Override
		public Email updateEmail(Email email) {
			return emailRepository.save(email);
		}

		@Override
		public Optional<Email> retrieveEmail(String id) {
			Optional<Email> email = emailRepository.findById(Long.parseLong(id));
			l.info("email :" + email);
			return email;
		}

		@Override
		public List<String> sendEmail() {
			// TODO Auto-generated method stub
			return null;
		}

}
