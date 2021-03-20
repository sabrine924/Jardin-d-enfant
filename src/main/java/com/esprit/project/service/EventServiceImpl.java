package com.esprit.project.service;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Event;
import com.esprit.project.entity.Parent;
import com.esprit.project.repository.EventRepository;
import com.esprit.project.repository.ParentRepository;



@Service 
public class EventServiceImpl implements IEventService {
	
	
	@Autowired
	EventRepository eventRepository;
	@Autowired
	ParentRepository parentRepository;
	private static final Logger L = LogManager.getLogger(EventServiceImpl.class);
	

	@Override
	public Event addEvents(Event E) {
		return eventRepository.save(E);
	}

	@Override
	public void deleteEventById(String idEvent) {
		eventRepository.deleteById(Long.parseLong(idEvent));
		
	}

	@Override
	public Event updateEvents(Event E) {
		
		return eventRepository.save(E);
	}

	@Override
	public List<Event> retrieveAllEvents() {
		List<Event> events = (List<Event>) eventRepository.findAll();
		for (Event event :  events){
			L.info("event +++ : " + event);
		}
		return   events ;
	}

	@Override
	public Optional<Event> retrieveEvents(String id) {
		Optional<Event> u = eventRepository.findById(Long.parseLong(id));
		return  u ;
		
	}

	@Override
	public void parentJoinEvent( Long identif, Long  idEvent) {
	     Event    eventEntity = eventRepository.findById(idEvent).get();
		Parent parentEntity= parentRepository.findById(identif).get();
		eventEntity.getParents().add(parentEntity);
		eventRepository.save(eventEntity);
			
	}

	@Override
	public void cancelUserAttendance(Long identif, Long idEvent) {
		 Event    eventEntity = eventRepository.findById(idEvent).get();
			Parent parentEntity= parentRepository.findById(identif).get();
			eventEntity.getParents().remove(parentEntity);
			eventRepository.save(eventEntity);
		
	}

	



}
