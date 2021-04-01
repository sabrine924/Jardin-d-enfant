package com.esprit.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Message;


@Repository
public interface MessageRepository extends CrudRepository<Message,Long>{

}
