package com.esprit.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="T_Delegate")
@PrimaryKeyJoinColumn(name = "id")
public class Delegate extends Parent {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;

	public Delegate(){
		
	}

	public Delegate(long id) {
		super();
		this.id = id;
	}
	
	

	public Delegate(long id, String firstName, String lastName, int phone, String email, String adress,
			String firstNameChild, String lastNameChild, String age, String health) {
		super(id, firstName, lastName, phone, email, adress, firstNameChild, lastNameChild, age, health);
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
