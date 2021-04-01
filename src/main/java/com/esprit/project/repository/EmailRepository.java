package com.esprit.project.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Email;

@Repository
public interface EmailRepository extends CrudRepository<Email,Long>{


	

}
