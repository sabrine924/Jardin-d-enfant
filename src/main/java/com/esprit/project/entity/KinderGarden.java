package com.esprit.project.entity;



import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="T_KinderGarden")
@PrimaryKeyJoinColumn(name = "id")
public class KinderGarden extends User {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Visitor> visitors;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kinderGarden")
	private Set<Inscription> inscriptions;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Event> event;
	

	
	public KinderGarden(){
		
	}
	
	public KinderGarden(long id, String firstName, String lastName, int phone, String email, String adress, long id2) {
		super(id, firstName, lastName, phone, email, adress);
		id = id2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "KinderGarden [id=" + id + "]";
	}
	
	
}
