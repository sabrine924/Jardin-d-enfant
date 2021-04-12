package com.esprit.project.entity;




import java.util.List;
//import java.util.Set;
//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import javax.persistence.JoinColumn;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="T_Parent")
@PrimaryKeyJoinColumn(name = "id")
public class Parent extends User {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
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
	
	@ManyToOne
	KinderGarden kindergarten;
	
	
	
	
	/*@ManyToMany( cascade=  CascadeType.ALL )
	@JoinTable(
			name = "Parent_Event",
			joinColumns =  @JoinColumn(name= "id") ,
		    inverseJoinColumns =  @JoinColumn(name = "id_event") 
			
			)
	@JsonIgnore*/
	@ManyToMany(mappedBy = "parents",  cascade =   CascadeType.ALL )
     private 	List<Event>  Events;
	
	
	
	
	/*@ManyToOne
	private Event events;*/
	
	@OneToMany(mappedBy = "parents",cascade = CascadeType.ALL)
    private 	List<Comment>  comments;
	
	
	

	public Parent(){
		
	}
	
	public Parent(long idParent, String firstName, String lastName, int phone, String email, String adress,
			String firstNameChild, String lastNameChild, String age, String health) {
		super(idParent, firstName, lastName, phone, email, adress);
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
	
	


	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public List<Event> getEvents() {
		return Events;
	}

	public void setEvents(List<Event> events) {
		Events = events;
	}

	
	@Override
	public String toString() {
		return "Parent [id=" + id + ", firstNameChild=" + firstNameChild + ", lastNameChild=" + lastNameChild + ", age="
				+ age + ", health=" + health + ", inscription=" + inscription + ", Events=" + Events + ", comments="
				+ comments + "]";
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
	
	
	

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}


	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

/*	public List<Cagnotte> getCagnotte() {
		return cagnotte;
	}

	public void setCagnotte(List<Cagnotte> cagnotte) {
		this.cagnotte = cagnotte;
	}*/


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((firstNameChild == null) ? 0 : firstNameChild.hashCode());
		result = prime * result + ((health == null) ? 0 : health.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastNameChild == null) ? 0 : lastNameChild.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (firstNameChild == null) {
			if (other.firstNameChild != null)
				return false;
		} else if (!firstNameChild.equals(other.firstNameChild))
			return false;
		if (health == null) {
			if (other.health != null)
				return false;
		} else if (!health.equals(other.health))
			return false;
		if (id != other.id)
			return false;
		if (lastNameChild == null) {
			if (other.lastNameChild != null)
				return false;
		} else if (!lastNameChild.equals(other.lastNameChild))
			return false;
		return true;
	}

	public KinderGarden getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(KinderGarden kindergarten) {
		this.kindergarten = kindergarten;
	}

	


	






	
	
	
	
}
