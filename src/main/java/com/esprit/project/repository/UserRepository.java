package com.esprit.project.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.project.entity.User;




@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
}
