package com.esprit.project.service;

import java.util.List;

import com.esprit.project.entity.Comment;

public interface ICommentService {
          
	void saveComment(Comment c);
	public void  deleteById(String id);
	List<Comment> findCommentsByEvent(Long idEvent);
}
