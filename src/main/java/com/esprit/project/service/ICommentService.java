package com.esprit.project.service;

import com.esprit.project.entity.Comment;

public interface ICommentService {
          
	void saveComment(Comment c);
	public void  deleteById(String id);
}
