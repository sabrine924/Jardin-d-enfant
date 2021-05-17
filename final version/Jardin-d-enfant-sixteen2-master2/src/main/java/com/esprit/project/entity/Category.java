package com.esprit.project.entity;

import javax.persistence.Column;

public class Category {
	
	
	@Column(name="name")
	 public String name;
	@Column(name="numberc")
	 public Long numberc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNumberc() {
		return numberc;
	}
	public void setNumberc(Long numberc) {
		this.numberc = numberc;
	}

}
