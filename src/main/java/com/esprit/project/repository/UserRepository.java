package com.esprit.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
