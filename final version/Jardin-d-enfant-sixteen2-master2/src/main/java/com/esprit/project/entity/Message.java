package com.esprit.project.entity;

import java.io.Serializable;

//import java.util.Date;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "message")
public class Message implements Serializable{
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", conversation=" + conversation + "]";
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private long id;
	
	@Lob
	private String text;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="conversation_id") 
	private Conversation conversation;
	
	public Message() {

	}

	public Message(String text, Conversation conversation) {
		super();
		this.text = text;
		this.conversation = conversation;
	}
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	
	
	
	
}