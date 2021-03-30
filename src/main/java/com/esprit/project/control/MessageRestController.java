package com.esprit.project.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Message;
import com.esprit.project.service.IGestionMessage;

@RestController
public class MessageRestController {
	
	@Autowired 
	IGestionMessage gestionMessage;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-messages
	@GetMapping("/retrieve-all-messages")
	@ResponseBody
	public List<Message> getMessages() {
	List<Message> list = gestionMessage.retrieveAllMessages();
	return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-message/{message-id}
	@GetMapping("/retrieve-rdv/{message-id}")
	@ResponseBody
	public Optional<Message> retrieveMessage(@PathVariable("message-id") String messageId) {
	return gestionMessage.retrieveMessage(messageId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-message
	@PostMapping("/add-message")
	@ResponseBody
	public Message addMessage(@RequestBody Message message1) {
	Message message = gestionMessage.addMessage(message1);
	return message;
	}
}
