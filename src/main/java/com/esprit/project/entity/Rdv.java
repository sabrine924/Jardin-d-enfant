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
	
	public Rdv(int idRdv, String id_Trans, Date date, String id_Emett, String subject) {
		super();
		this.idRdv = idRdv;
		Id_Trans = id_Trans;
		this.date = date;
		Id_Emett = id_Emett;
		Subject = subject;
	}

	@Column(name="Id_Trans")
	private String Id_Trans;
	
	public String getId_Trans() {
		return Id_Trans;
	}
	public void setId_Trans(String id_Trans) {
		Id_Trans = id_Trans;
	}
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
	@Column(name="Id_Emett")
	private String Id_Emett;
	public String getId_Emett() {
		return Id_Emett;
	}
	public void setId_Emett(String id_Emett) {
		Id_Emett = id_Emett;
	}

	@Column(name="Subject")
	 private String Subject;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="rdv")
	private Set<User> users; 
	
	
	
	
}
