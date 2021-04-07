package com.esprit.project.entity;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@Table(name="T_Parent")
@PrimaryKeyJoinColumn(name = "id")
public class Parent extends User {
	private static final long serialVersionUID = 1l;
	
	/*@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;*/
	@Column(name="First_Name_Child")
	private String firstNameChild;
	
	@Column(name="Last_Name_Child")
	private String lastNameChild;
	
	@Column(name="Age")
	private String age;
	
	@Column(name="Health")
	private String health;
	
	@ManyToOne
	Inscription inscription;
	
	@ManyToMany(mappedBy="Parents", cascade = CascadeType.ALL)
	private List<Event> events;
	
	
	
	public Parent(){
		
	}
	
	


	/*public Parent(long id, String firstName, String lastName, int phone, String email, String adress, long id2,
			String firstNameChild, String lastNameChild, String age, String health) {
		super(id, firstName, lastName, phone, email, adress);
		id = id2;
		this.firstNameChild = firstNameChild;
		this.lastNameChild = lastNameChild;
		this.age = age;
		this.health = health;
	}*/
	
	



	/*public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}*/
	


	public Parent(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, String firstName, String lastName, int phone, String adress,
			Set<Role> roles) {
		super(id, username, email, password, firstName, lastName, phone, adress, roles);
		// TODO Auto-generated constructor stub
	}




	public Parent(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, String firstName, String lastName, int phone, String adress) {
		super(username, email, password, firstName, lastName, phone, adress);
		// TODO Auto-generated constructor stub
	}




	public Parent(String username, String email, String password) {
		super(username, email, password);
		// TODO Auto-generated constructor stub
	}




	public Parent(String firstNameChild, String lastNameChild, String age, String health, Inscription inscription,
			List<Event> events) {
		super();
		this.firstNameChild = firstNameChild;
		this.lastNameChild = lastNameChild;
		this.age = age;
		this.health = health;
		this.inscription = inscription;
		this.events = events;
	}




	public String getFirstNameChild() {
		return firstNameChild;
	}


	public void setFirstNameChild(String firstNameChild) {
		this.firstNameChild = firstNameChild;
	}



	public String getLastNameChild() {
		return lastNameChild;
	}



	public void setLastNameChild(String lastNameChild) {
		this.lastNameChild = lastNameChild;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getHealth() {
		return health;
	}



	public void setHealth(String health) {
		this.health = health;
	}
	
	public String toString(){
		return super.toString()+"firstNameChild :" +firstNameChild + "lastNameChild :"+ lastNameChild+"age :"+age+"health"+health;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	
	
	
	
}
