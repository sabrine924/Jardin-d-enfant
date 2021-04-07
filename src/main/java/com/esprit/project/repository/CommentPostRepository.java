package com.esprit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.CommentPost;

@Repository
public interface CommentPostRepository extends JpaRepository<CommentPost,Long> {
	

}
