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
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kindergarten")
	private Set<Parent> parents;
	

	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Reclamation> reclamation ;
	
	@ManyToMany(mappedBy = "kindergartens",  cascade =   CascadeType.ALL )
    private 	List<Event>  Events;
	
	
	
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

	
	
	public Set<Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(Set<Visitor> visitors) {
		this.visitors = visitors;
	}

	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public List<Reclamation> getReclamation() {
		return reclamation;
	}

	public void setReclamation(List<Reclamation> reclamation) {
		this.reclamation = reclamation;
	}

	@Override
	public String toString() {
		return "KinderGarden [id=" + id + "]";
	}

	public Set<Parent> getParents() {
		return parents;
	}

	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}

	public List<Event> getEvents() {
		return Events;
	}

	public void setEvents(List<Event> events) {
		Events = events;
	}
	
	
	
}
