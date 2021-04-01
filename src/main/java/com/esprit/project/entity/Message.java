package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table( name = "T_Message")
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private int idMessage;
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
		}
	
	@Column(name="Trans_message")
	private String Trans_message;
	public Message() {
	
	}
	public Message(int idMessage, String trans_message, Date date, String description, String emett_message,
			String subject) {
		super();
		this.idMessage = idMessage;
		Trans_message = trans_message;
		this.date = date;
		Description = description;
		Emett_message = emett_message;
		Subject = subject;
		//this.users = users;
	}
	public Message(int idMessage, String trans_message, Date date, String description, String emett_message,
			String subject, Set<User> users) {
		super();
		this.idMessage = idMessage;
		Trans_message = trans_message;
		this.date = date;
		Description = description;
		Emett_message = emett_message;
		Subject = subject;
		this.users = users;
	}
	public String getTrans_message() {
		return Trans_message;
	}
	public void setTrans_message(String trans_message) {
		Trans_message = trans_message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	

	public String getEmett_message() {
		return Emett_message;
	}
	public void setEmett_message(String emett_message) {
		Emett_message = emett_message;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}

	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name="Description")
	 private String Description;
	@Column(name="Emett_message")
	private String Emett_message;
	@Column(name="Subject")
	 private String Subject;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="message")
	private Set<User> users; 
	
	
	
	
}
