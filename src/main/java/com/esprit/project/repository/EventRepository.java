package com.esprit.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Event;



@Repository
public interface EventRepository extends  CrudRepository<Event, Long > {


}
