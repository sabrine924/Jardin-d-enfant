package com.esprit.project.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class CommentPost {
	
		@Id
		@GeneratedValue
		private Long id;
		
		private String content;
		private int numbLikeComment;
		private int numbSignalComment;
		
		@ManyToOne(fetch=FetchType.LAZY)
		private Post post;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public int getNumbLikeComment() {
			return numbLikeComment;
		}

		public void setNumbLikeComment(int numbLikeComment) {
			this.numbLikeComment = numbLikeComment;
		}

		public int getNumbSignalComment() {
			return numbSignalComment;
		}

		public void setNumbSignalComment(int numbSignalComment) {
			this.numbSignalComment = numbSignalComment;
		}

		public Post getPost() {
			return post;
		}

		public void setPost(Post post) {
			this.post = post;
		}
		
		

		public CommentPost() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CommentPost(Long id, String content, int numbLikeComment, int numbSignalComment, Post post) {
			super();
			this.id = id;
			this.content = content;
			this.numbLikeComment = numbLikeComment;
			this.numbSignalComment = numbSignalComment;
			this.post = post;
		}
		
		
		
		
		
		
		
		

}
