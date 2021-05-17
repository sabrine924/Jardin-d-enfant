package com.esprit.project.control;




import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.esprit.project.service.Service;

import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.project.entity.Category;
import com.esprit.project.entity.CategoryEvent;
import com.esprit.project.entity.Event;
import com.esprit.project.entity.Inscription;
import com.esprit.project.entity.KinderGarden;
import com.esprit.project.entity.Parent;
import com.esprit.project.entity.Profile;
//import com.esprit.project.entity.Parent;
import com.esprit.project.entity.User;
import com.esprit.project.repository.EventRepository;
import com.esprit.project.service.EventPDFExporter;
import com.esprit.project.service.ICagnotteService;
import com.esprit.project.service.ICommentService;
import com.esprit.project.service.IEventService;
import com.esprit.project.service.IKinderGardenService;
import com.esprit.project.service.IParentService;
import com.esprit.project.service.IUserService;
import com.esprit.project.service.SmsRequest;
import com.lowagie.text.DocumentException;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EventRestController {
	
	@Autowired
	IEventService eventService;
	@Autowired 
	IParentService parentService;
	@Autowired 
	Service service ;
	@Autowired  
	IUserService us ;
	@Autowired  
	IKinderGardenService  ks;
	@Autowired
	EventRepository er;
	@Autowired
	ICommentService cs;
	@Autowired
	ICagnotteService js;
	
	
	
	 @GetMapping("/events/statistiques")
	 @ResponseBody
	 public List<Category> statistiques(){
		 System.out.println("statistiques");
		 return eventService.statistiques();
	 }
	 
	 
	 
	   @PostMapping("/up-event/{idEvent}")  
	    public Event updateEvent(@RequestBody Event event,@PathVariable("idEvent") long  idEvent) {  
	       event.setidEvent(idEvent) ;
	        return eventService.updateEvent(event);
	    }  
	 
	   
	     @PutMapping("/events/update-event")
	 	@ResponseBody
	 	public Event modifyEvent(@RequestBody Event E) {
	 	return eventService.updateEvents(E);
	 	}
	   
	   
	   

	     @GetMapping("/events/retrieve-Event-ByLocation/{location}")
			public  List<Event> getEventByLocation(@PathVariable String location) {
				List<Event> ev =  eventService.findEventByLocation(location);
				return  ev;
				
				}
	     
	
	     @GetMapping("/events/retrieveallevents")
	 	@ResponseBody
	 	public List<Event> getEvents() {
	 	List<Event> Event = eventService.retrieveAllEvents();
	 	return Event;
	 	}
	
	   @GetMapping("/events/retrieveevents/{event-id}")
	 	@ResponseBody
	 	public Optional<Event> retrieveUser(@PathVariable("event-id") long id) {
	 	return eventService.retrieveEvent(id);
	 	}
	  
	     
	     @PostMapping("/events/addevent")
	 	@ResponseBody
	 	public Event addEvent(@RequestBody Event E) {
	 		System.out.println(E);
	 		Event event = eventService.addEvents(E);
	 	return event;
	 	}
	
	     @DeleteMapping("/events/delete-event/{event-id}")
	 	@ResponseBody
	 	public void removeEvent(@PathVariable("event-id") String id) {
	 		
	 		eventService.deleteById(id);
	 }
	
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
	 				String message = "Bonjour Mr/Mme "+parent.getLastName()+" "+parent.getFirstName() + "  " + " \n Vous etes  inscrit  a l'evenemement  "+ " " +event.getName()
	 						+ " localise a "+ " "+ event.getLocation()+" a "+ " "+event.getStartHour()+"h" + "    "+ "." + "Le prix de ticket vaut "+event.getJackpotDonation()+" dt";
	 				SmsRequest smsRequest = new SmsRequest("+216"+parent.getPhone(), message);
	 				System.out.println(smsRequest);
	 				//service.sendSms(smsRequest);
	 				
	 			}
	 			
	 		}
	 		return "message envoye";
	 		
	 }
	
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
	
	
	 	@PostMapping( "/events/{idEvent}/Kindergartens/{id}")
		@ResponseBody
		public String  KinderGartenJoinEvent(
				@PathVariable("id") Long  id,
				@PathVariable("idEvent") Long idEvent) {
			eventService.KinderGartenJoinEvent(idEvent, id);
			Optional<KinderGarden> g = ks.retrieveKinderGarden(id+"");
			String message ;
			SmsRequest smsRequest;
			if(g.isPresent()){
				//Sending Message to kinderGarden
				Optional<Event> e = eventService.retrieveEvents(idEvent+"");
				if(e.isPresent()){
					KinderGarden kindergarten = g.get() ;
					Event event = e.get();
					 message = "Bonjour  Mr/Mme directeur jardin" +kindergarten.getFirstName() +"   "+kindergarten.getLastName() +"  " + "\nvous etes invites a rejoindre l'evenement de competition entre les differents jardin d'enfant " 
					+event.getName()+"  "+"qui va se derouler a " +event.getLocation()+"  "+"de" + " " +event.getStartHour()+"a"+event.getEndHour()+" ";
					smsRequest = new SmsRequest("+216"+kindergarten.getPhone(), message);
					System.out.println(smsRequest);
				  // service.sendSms(smsRequest);
					
					
					//sending Message to kinderGarden's parents
					
					for(Inscription in : kindergarten.getInscriptions()){
						for(Parent par: in.getParents()){
				  
							message = "Bonjour  Mr/Mme  " +par.getFirstName() +""+par.getLastName()+ "vous etes invites a rejoindre l'evenement de competition entre les differents jardin d'enfant " 
									+event.getName()+""+"qui va se derouler a " +event.getLocation()+"de"+event.getStartHour()+"a"+event.getEndHour()+" ";
							smsRequest = new SmsRequest("+216"+kindergarten.getPhone(), message);
							service.sendSms(smsRequest);
						}
					}
				}	
			}
			return "message envoye";
			
	}
	
	 	@GetMapping("/events/retrieve-Event-ByName/{name}")
		public  List<Event> getEventByName(@PathVariable String name) {
	 		List<Event> ev =  eventService.findEventByName(name);
			return ev;
			}
	
	 	@GetMapping("/event/getEventsBetweenTwoDates/{date1}/{date2}")
		public List<String> getEventBetweenTwoDates(@PathVariable("date1")String date1,@PathVariable("date2")String date2) throws java.text.ParseException {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			Date date1Converted = dateFormat.parse(date1);
			Date date2Converted = dateFormat.parse(date2);
			return eventService.getEventTwoDatesBeetween(date1Converted,date2Converted);
		}
	
	 	@GetMapping("/event/retrieve-Event-ByCategory/{category}")
		public List<Event> getEventByCategory(@PathVariable CategoryEvent category) {
			 List<Event> ev = eventService.filterByCategory(category);
			return ev;
			}
	
	 	@PutMapping("/event/affecter-category-event/{category}/{idevent}")  
		public String affecterCategoryEvent(@PathVariable("category")String category,@PathVariable("idEvent")long idEvent)   
		{  
				
					return eventService.affecterCategoryEvent(category, idEvent);
					
		}
	 	 @GetMapping("/events/export/pdf")
		    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		        response.setContentType("application/pdf");
		        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		        String currentDateTime = dateFormatter.format(new Date());
		         
		        String headerKey = "Content-Disposition";
		        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		        response.setHeader(headerKey, headerValue);
		         
		        List<Event> listEvents =eventService.retrieveAllEvents();
		         
		        EventPDFExporter exporter = new EventPDFExporter(listEvents);
		        exporter.export(response);
		         
	 	
}
}
	
	
	
	
     
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-events
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-events/{event-id}
	
	//http://localhost:8081/SpringMVC/servlet/add-event
	//@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
/*	@PostMapping("/add-event")
	@ResponseBody
	public Event addEvent(@RequestBody Event E) {
		Event event = eventService.addEvents(E);
		 /*Event event.
		Optional<User> p = us.retrieveUser(id+"");
		if(p.isPresent()){
			Optional<Event> e = eventService.retrieveEvents(idEvent+"");
			if(e.isPresent()){
				User parent = p.get() ;
				Event event = e.get();
				String message = "Bonjour Mr/Mme "+parent.getLastName()+" "+parent.getFirstName() + "  Vous etes  inscrit  a l'evenemement  "+event.getName()
						+ " localise a "+event.getLocation()+" a "+event.getStartHour()+"h. Le prix de ticket vaut "+event.getJackpotDonation()+" dt";
				SmsRequest smsRequest = new SmsRequest("+216"+parent.getPhone(), message);
				System.out.println(smsRequest);
				//service.sendSms(smsRequest);
				
			}*/
		
		
	//return event;
	//}
	
	//http://localhost:8081/SpringMVC/servlet/remove-event/{event-id}
	/*@DeleteMapping("/remove-event/{event-id}")
	@ResponseBody
	public void removeEvent(@PathVariable("event-id") String id) {
	eventService.deleteEventById(id);
	}*/
	

	//http://localhost:8081/SpringMVC/servlet/modify-event
	/*@PutMapping("/modify-event")
	@ResponseBody
	public Event modifyUser(@RequestBody Event event) {
	return eventService.updateEvents(event);
 
	}*/
	
	//http://localhost:8081/SpringMVC/servlet/events/{idEvent}/parents/{id}
	/*@PutMapping("/events/cancelUserAttendance/{idEvent}/parents/{id}")
	@ResponseBody
	public void  cancelUserAttendance(
			@PathVariable("id") Long  id,
			@PathVariable("idEvent") Long  idEvent) {
		eventService.cancelUserAttendance(idEvent, id);
	}*/
	
	

		



