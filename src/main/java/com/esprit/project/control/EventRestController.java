package com.esprit.project.control;


import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Event;
import com.esprit.project.service.IEventService;
import com.esprit.project.service.IParentService;



@RestController
public class EventRestController {
	
	@Autowired
	IEventService eventService;
	@Autowired 
	IParentService parentService;
    
	
	@GetMapping("/retrieve-all-events")
	@ResponseBody
	public List<Event> getEvents() {
	List<Event> Event = eventService.retrieveAllEvents();
	return Event;
	}
	
	
	@GetMapping("/retrieve-events/{event-id}")
	@ResponseBody
	public Optional<Event> retrieveUser(@PathVariable("event-id") String id) {
	return eventService.retrieveEvents(id);
	}
	
	/*@PostMapping("/add-event")
	@ResponseBody
	public Event addEvent(@RequestBody Event E) {
	Event user = eventService.addEvents(E);
	return user;
	}*/
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Validated @RequestBody Event event) {
		eventService.add(event);
		return new ResponseEntity<Void>(null, null, HttpStatus.SC_CREATED);
	}
	
	@DeleteMapping("/remove-event/{event-id}")
	@ResponseBody
	public void removeEvent(@PathVariable("event-id") String id) {
	eventService.deleteEventById(id);
	}
	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<?> updateEvents(@RequestBody Event event) {
		
		Optional<Event> optEvent = eventService.update(event);
		if (optEvent.isPresent()) {
			return new ResponseEntity<Event>(optEvent.get(), null, HttpStatus.SC_NO_CONTENT);
		}
		return new ResponseEntity<Void>(null, null, HttpStatus.SC_NOT_FOUND);
	}
	@PutMapping(value="/parentJoinEvent/{id}/{idEvent}")
	public void  parentJoinEvent(@PathVariable("idEvent") Long idEvent, @PathVariable("id") Long id ){
		eventService.parentJoinEvent(id, idEvent);
	}
	
	@PutMapping(value="/cancelParentAttendance/{id}/{idEvent}")
	public void  cancelParentAttendance(@PathVariable("idEvent") Long idEvent, @PathVariable("id") Long id ){
		eventService.cancelParentAttendance(id, idEvent);
	}

}
	
	


