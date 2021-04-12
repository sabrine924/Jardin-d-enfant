package com.esprit.project.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="comments")

public class Comment {
	
	@Id
	@GeneratedValue
	private Long idComment;
	@Column(name="content")
	private String content;
	
     @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
     private Parent parents;
     
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Event event;


	public Long getId() {
		return idComment;
	}

	public void setId(Long idComment) {
		this.idComment = idComment;
	}


	public Parent getParents() {
		return parents;
	}

	public void setParents(Parent parents) {
		this.parents = parents;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	


	public Comment() {
	 
	}


	public Comment(Long idComment, String content) {
		this.idComment = idComment;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [idComment=" + idComment+ ", content=" + content + "]";
	}

	





	

}
