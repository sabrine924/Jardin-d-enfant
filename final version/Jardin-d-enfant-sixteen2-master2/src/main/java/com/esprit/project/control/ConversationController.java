package com.esprit.project.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Conversation;
import com.esprit.project.entity.Message;
//import com.esprit.project.entity.Rdv;
import com.esprit.project.service.ConversationService;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin("*")
@RestController
public class ConversationController {
	
	@Autowired
	private ConversationService conversationService;
	//http://localhost:8081/addconversation
	  @PostMapping(value = "/conversations") 
	  public ResponseEntity uploadMessage(@RequestParam("userId") Long userId, /*@RequestParam("conversation_id") Long conv_id,*/ @RequestParam("message") String text) {
		  String messageResponse = ""; 
		  Message message = new Message();
		  try { 
			  
			  message = new ObjectMapper().readValue(text, Message.class);
			  
			  conversationService.store(userId,/* conv_id,*/ message);

			  messageResponse = "Uploaded successfully: ";
	  
		  	return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
	  
	  } catch (Exception e) { e.printStackTrace(); 
	  			messageResponse = "Could not upload the conversation!"; 
	  			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(messageResponse); } }
	  
	  
	// http://localhost:8081/retrieve-all-conversations
	  @GetMapping("/conversations")
		@ResponseBody
		public List<Conversation> getConversations() {
		List<Conversation> list = conversationService.retrieveAllConversations();
		return list;
		}
		//http://localhost:8081/delete-conversation
		@DeleteMapping("/conversations/{conversation-id}")
		@ResponseBody
		public void removeConversation(@PathVariable("conversation-id") String id) {
			conversationService.deleteConversation(id);
		}
		
		//http://localhost:8081/retrieve-conversation
		@GetMapping("/conversations/{conversation-id}")
		@ResponseBody
		public Optional<Conversation> retrieveConversation(@PathVariable("conversation-id") String id) {
		return conversationService.retrieveConversation(id);
		}

}


