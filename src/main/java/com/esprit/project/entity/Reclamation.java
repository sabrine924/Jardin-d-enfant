package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
	@Table(name = "T_Reclamation")
	public class Reclamation implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue ( strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name="Subject")
		private String subject;
		@Column(name="Description")
		private String description;
		@Temporal(TemporalType.DATE)
		private Date date;
		
		@ManyToMany( cascade=  CascadeType.ALL )
		private List<Parent> parents;
		
		@ManyToOne
		KinderGarden kinderGarden;
		
		@ManyToOne
		 private Administrator  administrator;
		
		
		public Long getid() {
			return id;
		}
		public void setid(Long id) {
			this.id = id;
		}
		
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		@Override
		public String toString() {
			return "Reclamation [id=" + id + ",  + " 
					+ ", subject=" + subject + ", description=" + description + ", date=" + date + "]";
		}
		public Reclamation() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Reclamation(Long id, String subject, String description, Date date) {
			super();
			this.id = id;
			this.subject = subject;
			this.description = description;
			this.date = date;
		}
		public List<Parent> getParents() {
			return parents;
		}
		public void setParents(List<Parent> parents) {
			this.parents = parents;
		}
		public KinderGarden getKinderGarden() {
			return kinderGarden;
		}
		public void setKinderGarden(KinderGarden kinderGarden) {
			this.kinderGarden = kinderGarden;
		}
		public Administrator getAdministrator() {
			return administrator;
		}
		public void setAdministrator(Administrator administrator) {
			this.administrator = administrator;
		}
		
	
		
		
	}



