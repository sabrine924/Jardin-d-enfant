package com.esprit.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "T_Email")
public class Mailing implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private int idEmail;
	public int getIdEmail() {
		return idEmail;
	}
	public void setIdEmail(int idEmail) {
		this.idEmail = idEmail;
	}
	public String getTrans_mail() {
		return Trans_mail;
	}
	public void setTrans_mail(String trans_mail) {
		Trans_mail = trans_mail;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
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
	@Column(name="Trans_mail")
	private String Trans_mail;
	@Column(name="Subject")
	private String Subject;
	@Column(name="Description")
	 private String Description;
	@Column(name="Emett_mail")
	private String Emett_mail;

}
