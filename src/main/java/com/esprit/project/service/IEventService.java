package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import com.esprit.project.entity.Event;



public interface IEventService {
	
	  Event  addEvents(Event E);
	  void    deleteEventById(String idEvent);
	  public Optional<Event> update(Event event);
	  List<Event> retrieveAllEvents();
	  Optional<Event> retrieveEvents(String id);
	void parentJoinEvent(Long id, Long idEvent);
	 void cancelParentAttendance(Long id, Long idEvent);
	Event add(Event E);
	Event findEventById(Long idEvent);

	
	
	 
	  
	

	

	
}
