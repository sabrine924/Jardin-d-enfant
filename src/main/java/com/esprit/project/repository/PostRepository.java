package com.esprit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Long>{

}
