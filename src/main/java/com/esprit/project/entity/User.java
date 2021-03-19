package com.esprit.project.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Table(name="T_USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="Phone_Number")
	private int phone;
	
	@Column(name="Mail_Adress")
	private String email;
	
	@Column(name="Adress")
	private String adress;
	
	@OneToOne
	private Account account;
	
	@OneToOne
	private Profile profile;
	
	public User(){
		
	}

	
	public User(long id, String firstName, String lastName, int phone, String email, String adress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.adress = adress;
	}
	
	

	public User(String firstName, String lastName, int phone, String email, String adress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.adress = adress;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String toString(){
		return "id :" + id +"firstName :" + firstName +"lastName :"+ lastName +"phone :" +phone+"email :"+email +"adress :"+adress;
	}
}
