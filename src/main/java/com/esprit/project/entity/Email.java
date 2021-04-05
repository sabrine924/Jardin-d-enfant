package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "T_Email")
public class Email implements Serializable {
	
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
	public Email(int idEmail, String User_email, String subject, String description, String Administrator_email) {
		super();
		this.idEmail = idEmail;
		User_email = user_email;
		Subject = subject;
		Description = description;
		Administrator_email = administrator_email;
	
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getAdministrator_email() {
		return administrator_email;
	}
	public void setAdministrator_email(String administrator_email) {
		this.administrator_email = administrator_email;
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
	
	@Column(name="user_email")
	private String user_email;
	@Column(name="Subject")
	private String Subject;
	@Column(name="Description")
	 private String Description;
	@Column(name="administrator_email")
	private String administrator_email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="email")
	private Set<User> users;

	
	
	
	

}
