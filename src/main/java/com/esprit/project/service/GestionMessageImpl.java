package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Message;


@Service
public class GestionMessageImpl implements IGestionMessage{
	
	@Autowired
	MessageRepository messagerepository;
	private static final Logger l = LogManager.getLogger(AccountServiceImpl.class);

	@Override
	public List<Message> retrieveAllMessages() {
		List<Message> messages = (List<Message>) messagerepository.findAll();
		for (Message message : messages){
			l.info("message : " + message);
		}
		return messages;
	}

	@Override
	public Message addMessage(Message mes) {
		return messagerepository.save(mes);
	}

	@Override
	public Optional<Message> retrieveMessage(String id) {
		Optional<Message> message = messagerepository.findById(Long.parseLong(id));
		l.info("message :" + message);
		return message;
	}
	
	
	
}
