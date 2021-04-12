package com.esprit.project.service;



import java.util.List;

import com.esprit.project.entity.Comment;
import com.esprit.project.entity.Parent;

public interface ICommentService {
          
	Comment saveComment(Comment c);
	public void  deleteById(String id);
	List<Comment>  retrieveAllComments();
	List<Comment> getCommentsByEventId(long idEvent);
	public void parentCommentEvent(Long idComment,  Long id);
	
	
}
