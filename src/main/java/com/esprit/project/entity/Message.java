package com.esprit.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	public String getTrans_message() {
		return Trans_message;
	}
	public void setTrans_message(String trans_message) {
		Trans_message = trans_message;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getEmett_mail() {
		return Emett_mail;
	}
	public void setEmett_mail(String emett_mail) {
		Emett_mail = emett_mail;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}

	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	private String Date;
	@Column(name="Description")
	 private String Description;
	@Column(name="Emett_message")
	private String Emett_mail;
	@Column(name="Subject")
	 private String Subject;

	
	
	
	
}
