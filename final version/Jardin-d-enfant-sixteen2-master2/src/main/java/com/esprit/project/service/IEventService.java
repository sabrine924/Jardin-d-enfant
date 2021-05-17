package com.esprit.project.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.esprit.project.entity.Category;
import com.esprit.project.entity.CategoryEvent;
import com.esprit.project.entity.Event;




public interface IEventService {
	
	Event  addEvents(Event E);
	  void    deleteEventById(String idEvent);
	 //Event  updateEvents(Event E);
	  List<Event> retrieveAllEvents();
	  Optional<Event> retrieveEvents(String id);
	 void parentJoinEvent(Long idEvent,  Long id);
	// void cancelUserAttendance(Long idEvent,  Long id);
	 void AffecterCagnotteAEvent(String idCagnotte, String idEvent );
	 Map<String, String> getNbrParticipants(Long idEvent);
	 Map<String, Object> getMaxCagnotte();
	 void KinderGartenJoinEvent(Long idEvent,  Long id);
	  List<Event> findEventByName(String name);
	List<String> getEventTwoDatesBeetween(Date date1, Date date2);
	Event findbyId(long id);
	List<Event> filterByCategory(CategoryEvent category);
	String affecterCategoryEvent(String category, long idEvent);
	void deleteById(String id);
	Optional<Event> retrieveEvent(long idEvent);
	List<Event> findEventByLocation(String location);
	//Map<CategoryEvent,Long> statistiques ();
	//List<Category> GetStat();
	List<Category> statistiques();
	// public Event updateEvent(Event event); 
	//Event updateEvent(Event event);
	//Event updateEvent(Event event);
	public Event updateEvents(Event E);
	 public Event updateEvent(Event event);  
	


}
