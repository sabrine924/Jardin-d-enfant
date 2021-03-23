package com.esprit.project.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table( name = "T_Events")
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	 private Long  idEvent;
	@Column(name="Subject")
	 private String Subject;
	@Column(name="Description")
	 private String Description;
	@Column(name="heure_debut")
	 private int startHour;
	@Column(name="heure_fin")
	 private int  EndHour;
	@JsonFormat(pattern = "MM/dd/yyyy hh:mm:ss")
	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	 private Date  date;
	@Column(name="nombre_like")
	private int  nbrlike ;
	@Column(name="Name")
	private String Name;
	@Column(name="Location")
	private String Location;
	
	
	@OneToMany(mappedBy="event", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Comment> comments;
	

	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Parent> Parents;
	
	@ManyToOne
	KinderGarden kinderGarden;

	
	
	
	/*@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CAL_ID")
    @JsonBackReference
    private CalendarEvents calendar;
	    public CalendarEvents getCalendar() {
	        return calendar;
	    }

	    public void setCalendar(CalendarEvents calendar) {
	        this.calendar = calendar;
	    }*/
	    
	    public Event() {
			
		}
	public Long getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
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
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNbrlike() {
		return nbrlike;
	}
	public void setNbrlike(int nbrlike) {
		this.nbrlike = nbrlike;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getEndHour() {
		return EndHour;
	}
	public void setEndHour(int endHour) {
		EndHour = endHour;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
	
	public Event(Long idEvent, String subject, String description, int startHour, int endHour, Date date, int nbrlike,
			String name, String location) {
		
		this.idEvent = idEvent;
		this.Subject = subject;
		this.Description = description;
		this.startHour = startHour;
		this.EndHour = endHour;
		this.date = date;
		this.nbrlike = nbrlike;
		this.Name = name;
		this.Location = location;
	}
	
	
	public Event(long idEvent, String subject, String description, int startHour, int endHour, Date date, int nbrlike, String name, String location) {
		this.idEvent = idEvent;
		this.Subject = subject;
		this.Description = description;
		this.startHour = startHour;
		this.EndHour = endHour;
		this.date = date;
		this.nbrlike = nbrlike;
		this.Name = name;
		this.Location = location;
	}

	

	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Parent> getParents() {
		return Parents;
		
	}
	public void setParents(List<Parent> parents) {
		Parents = parents;
	}
	
	
	@Override
	public String toString() {
		return "Event [idEvent=" + idEvent + ", Subject=" + Subject + ", Description=" + Description + ", startHour="
				+ startHour + ", EndHour=" + EndHour + ", date=" + date + ", nbrlike=" + nbrlike + ", Name=" + Name
				+ ", Location=" + Location + "]";
	}
	
    
	
	

	}

	
	 

	

