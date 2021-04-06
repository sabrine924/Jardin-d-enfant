package com.esprit.project.control;




import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.esprit.project.service.Service;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.project.entity.Event;
//import com.esprit.project.entity.Parent;
import com.esprit.project.entity.User;
import com.esprit.project.service.IEventService;
import com.esprit.project.service.IParentService;
import com.esprit.project.service.IUserService;
import com.esprit.project.service.SmsRequest;


@RestController
public class EventRestController {
	
	@Autowired
	IEventService eventService;
	@Autowired 
	IParentService parentService;
	@Autowired 
	Service service ;
	@Autowired  
	IUserService us ;
	
     
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-events
	@GetMapping("/retrieve-all-events")
	@ResponseBody
	public List<Event> getEvents() {
	List<Event> Event = eventService.retrieveAllEvents();
	return Event;
	}
	//http://localhost:8081/SpringMVC/servlet/retrieve-events/{event-id}
	@GetMapping("/retrieve-events/{event-id}")
	@ResponseBody
	public Optional<Event> retrieveUser(@PathVariable("event-id") String id) {
	return eventService.retrieveEvents(id);
	}
	//http://localhost:8081/SpringMVC/servlet/add-event
	//@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/add-event")
	@ResponseBody
	public Event addEvent(@RequestBody Event E) {
		Event event = eventService.addEvents(E);	
		
	return event;
	}
	
	//http://localhost:8081/SpringMVC/servlet/remove-event/{event-id}
	@DeleteMapping("/remove-event/{event-id}")
	@ResponseBody
	public void removeEvent(@PathVariable("event-id") String id) {
	eventService.deleteEventById(id);
	}
	

	//http://localhost:8081/SpringMVC/servlet/modify-event
	@PutMapping("/modify-event")
	@ResponseBody
	public Event modifyUser(@RequestBody Event event) {
	return eventService.updateEvents(event);
	}
	
	//http://localhost:8081/SpringMVC/servlet/events/{idEvent}/parents/{id}
	/*@PutMapping("/events/cancelUserAttendance/{idEvent}/parents/{id}")
	@ResponseBody
	public void  cancelUserAttendance(
			@PathVariable("id") Long  id,
			@PathVariable("idEvent") Long  idEvent) {
		eventService.cancelUserAttendance(idEvent, id);
	}*/
	
	
	//http://localhost:8081/SpringMVC/servlet/events/{idEvent}/parents/{id}

	@PostMapping( "/events/{idEvent}/parents/{id}")
	@ResponseBody
	public String  parentJoinEvent(
			@PathVariable("id") Long  id,
			@PathVariable("idEvent") Long idEvent) {
		eventService.parentJoinEvent(idEvent, id);
		Optional<User> p = us.retrieveUser(id+"");
		if(p.isPresent()){
			Optional<Event> e = eventService.retrieveEvents(idEvent+"");
			if(e.isPresent()){
				User parent = p.get() ;
				Event event = e.get();
				String message = "Bonjour Mr/Mme "+parent.getLastName()+" "+parent.getFirstName() + " Vous etes invite a l'evenement "+event.getName()
						+ " localise a "+event.getLocation()+" a "+event.getStartHour()+"h. Le prix de ticket vaut "+event.getCagnotte().getAmount()+" dt";
				SmsRequest smsRequest = new SmsRequest("+216"+parent.getPhone(), message);
				System.out.println(smsRequest);
				service.sendSms(smsRequest);
				
			}
			
		}
		return "message envoye";
		
}
	//http://localhost:8081/SpringMVC/servlet/events/{idEvent}/cagnottes/{idCagnotte}
		@PostMapping( "/events/{idEvent}/cagnottes/{idCagnotte}")
		@ResponseBody
		public void  AffecterCagnotteAEvent(
				@PathVariable("idEvent") String  idEvent,
				@PathVariable("idCagnotte") String idCagnotte) {
			
			eventService.AffecterCagnotteAEvent(idCagnotte, idEvent);

	}
		@GetMapping("/participants/count/{id}")
		@ResponseBody
		public Map<String, String> getDetailsEvent(@PathVariable("id") Long  idEvent) {
			return eventService.getNbrParticipants(idEvent);
		}
		
		@GetMapping("/participants/maxcagnotte")
		@ResponseBody
		public Map<String, Object> getMaxCagnotte() {
			return eventService.getMaxCagnotte();
		}

}
