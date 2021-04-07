package com.esprit.project.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



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
	
	@OneToMany(mappedBy="Parent", cascade = CascadeType.ALL)
	private List<Post> posts;
	
	
	
	public Parent(){
		
	}
	
	public Parent(long id, String firstName, String lastName, int phone, String email, String adress,
			String firstNameChild, String lastNameChild, String age, String health) {
		super(id, firstName, lastName, phone, email, adress);
		this.firstNameChild = firstNameChild;
		this.lastNameChild = lastNameChild;
		this.age = age;
		this.health = health;
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
