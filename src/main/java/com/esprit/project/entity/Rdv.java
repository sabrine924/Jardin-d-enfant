package com.esprit.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="Id_Trans")
	private String Id_Trans;
	
	public String getId_Trans() {
		return Id_Trans;
	}
	public void setId_Trans(String id_Trans) {
		Id_Trans = id_Trans;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}

	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	private String Date;
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

	
	
	
	
}
