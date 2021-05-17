package com.esprit.project.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Conversation;
import com.esprit.project.entity.Message;

public interface IConversationService {
	
	Conversation findById(Long id);
	List<Conversation> retrieveAllConversations();
	void deleteConversation(String id);
	Optional<Conversation> retrieveConversation(String id);
	void store(Long userId,/* Long conv_id,*/ Message text) throws IOException ;
}
