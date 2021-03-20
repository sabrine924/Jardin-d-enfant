package com.esprit.project.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Comment;

@Repository
public interface CommentRepositroy  extends CrudRepository<Comment , Long> {


	
	
}
