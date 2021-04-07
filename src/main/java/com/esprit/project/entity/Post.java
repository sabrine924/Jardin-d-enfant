package com.esprit.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_Post")
public class Post implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPost;
	@Temporal(TemporalType.DATE)
	private Date datePublicationPost;
	private String subjectPost;
	private String descriptionPost;
	private String numbCommentPost;
	private int numbLikePost;
	private int numbDislikePost;
	private int numbSignalPost;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Post(Long idPost, Date datePublicationPost, String subjectPost, String descriptionPost,
			String numbCommentPost, int numbLikePost, int numbDislikePost, int numbSignalPost) {
		super();
		this.idPost = idPost;
		this.datePublicationPost = datePublicationPost;
		this.subjectPost = subjectPost;
		this.descriptionPost = descriptionPost;
		this.numbCommentPost = numbCommentPost;
		this.numbLikePost = numbLikePost;
		this.numbDislikePost = numbDislikePost;
		this.numbSignalPost = numbSignalPost;
	}
	@OneToMany(mappedBy="post", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<CommentPost> commentsPost;
	
	@ManyToOne
	private Parent Parent;
	
	@ManyToOne
	private KinderGarden kinderGarden;
	

	

	public Parent getParent() {
		return Parent;
	}

	public void setParent(Parent parent) {
		Parent = parent;
	}

	public KinderGarden getKinderGarden() {
		return kinderGarden;
	}

	public void setKinderGarden(KinderGarden kinderGarden) {
		this.kinderGarden = kinderGarden;
	}

	

	public List<CommentPost> getCommentsPost() {
		return commentsPost;
	}

	public void setCommentsPost(List<CommentPost> commentsPost) {
		this.commentsPost = commentsPost;
	}

	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	public Date getDatePublicationPost() {
		return datePublicationPost;
	}
	public void setDatePublicationPost(Date datePublicationPost) {
		this.datePublicationPost = datePublicationPost;
	}
	public String getSubjectPost() {
		return subjectPost;
	}
	public void setSubjectPost(String subjectPost) {
		this.subjectPost = subjectPost;
	}
	public String getDescriptionPost() {
		return descriptionPost;
	}
	public void setDescriptionPost(String descriptionPost) {
		this.descriptionPost = descriptionPost;
	}
	public String getNumbCommentPost() {
		return numbCommentPost;
	}
	public void setNumbCommentPost(String numbCommentPost) {
		this.numbCommentPost = numbCommentPost;
	}
	public int getNumbLikePost() {
		return numbLikePost;
	}
	public void setNumbLikePost(int numbLikePost) {
		this.numbLikePost = numbLikePost;
	}
	public int getNumbDislikePost() {
		return numbDislikePost;
	}
	public void setNumbDislikePost(int numbDislikePost) {
		this.numbDislikePost = numbDislikePost;
	}
	public int getNumbSignalPost() {
		return numbSignalPost;
	}
	public void setNumbSignalPost(int numbSignalPost) {
		this.numbSignalPost = numbSignalPost;
	}
	

}
