package com.esprit.project.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

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


@RestController
public class EventRestController {
	
	@Autowired
	IEventService eventService;
    
	
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
	
	@PostMapping("/add-event")
	@ResponseBody
	public Event addEvent(@RequestBody Event E) {
	Event user = eventService.addEvents(E);
	return user;
	}
	@DeleteMapping("/remove-event/{event-id}")
	@ResponseBody
	public void removeEvent(@PathVariable("event-id") String id) {
	eventService.deleteEventById(id);
	}
	@PutMapping("/modify-event")
	@ResponseBody
	public Event modifyUser(@RequestBody Event event) {
	return eventService.updateEvents(event);
	}

}
