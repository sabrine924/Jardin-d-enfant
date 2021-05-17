package com.esprit.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>  {

	@Query(value = "SELECT m FROM Message m WHERE m.conversation.id = :id")
	 List<Message> findMessageByConversationId(@Param("id")Long id);

}
