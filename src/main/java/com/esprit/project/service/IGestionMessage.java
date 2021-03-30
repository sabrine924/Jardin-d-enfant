package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Message;

public interface IGestionMessage {
	
	List<Message> retrieveAllMessages();
	Message addMessage(Message mes);
	Optional<Message> retrieveMessage(String id);
}
