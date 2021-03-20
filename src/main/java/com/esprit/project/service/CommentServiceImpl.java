package com.esprit.project.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Comment;
import com.esprit.project.repository.CommentRepositroy;


@Service
public class CommentServiceImpl implements ICommentService {
     
	
	@Autowired
	 CommentRepositroy commentrepository;

	@Override
	public void saveComment(Comment c) {
		commentrepository.save(c);
		
	}

	@Override
	public void deleteById(String id) {
		commentrepository.deleteById(Long.parseLong(id));
		
	}
	
	
}
