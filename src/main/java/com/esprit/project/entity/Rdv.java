package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "T_Rdv")
public class Rdv implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private int idRdv;
	public int getIdRdv() {
		return idRdv;
	}
	public void setIdRdv(int idRdv) {
		this.idRdv = idRdv;
		}
	
	public Rdv(int idRdv, String id_User, Date date, String id_Administrator, String subject) {
		super();
		this.idRdv = idRdv;
		Id_User = id_User;
		this.date = date;
		Id_Administrator = id_Administrator;
		Subject = subject;
	}

	@Column(name="id_User")
	private String Id_User;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}

	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name="Id_Administrator")
	private String Id_Administrator;
	

	@Column(name="Subject")
	 private String Subject;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="rdv")
	private Set<User> users; 
	
	
	
	
}
