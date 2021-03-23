package com.esprit.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Mailing;

@Repository
public interface MailingRepository extends CrudRepository<Mailing,Long>{


	

}
