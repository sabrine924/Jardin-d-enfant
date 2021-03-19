package com.esprit.project.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Parent;





@Repository
public interface ParentRepository extends CrudRepository<Parent, Long> {
	
}
