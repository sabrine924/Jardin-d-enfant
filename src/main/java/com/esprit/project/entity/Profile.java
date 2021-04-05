package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_Profile")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Number_Employees")
	private int numberemployes;
	
	@Temporal(TemporalType.DATE)
	private Date datecreaction;
	
	@Column(name="Phone_Number")
	private int phone;
	
	@Column(name="Adress")
	private String adress;

	@Column(name="Location")
	private String location;

	@OneToOne
	private User user;
	
	
	public Profile(){
		
	}
	public Profile(long id, int numberemployes, Date datecreaction, int phone, String adress, String location) {
		super();
		this.id = id;
		this.numberemployes = numberemployes;
		this.datecreaction = datecreaction;
		this.phone = phone;
		this.adress = adress;
		this.location = location;
	}

	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public int getNumberemployes() {
		return numberemployes;
	}

	public void setNumberemployes(int numberemployes) {
		this.numberemployes = numberemployes;
	}

	public Date getDatecreaction() {
		return datecreaction;
	}

	public void setDatecreaction(Date datecreaction) {
		this.datecreaction = datecreaction;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
