package com.esprit.project.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Cagnotte;
import com.esprit.project.entity.Event;
import com.esprit.project.entity.Parent;
import com.esprit.project.repository.CagnotteRepository;
import com.esprit.project.repository.EventRepository;
import com.esprit.project.repository.ParentRepository;



@Service 
public class EventServiceImpl implements IEventService {
	
	
	@Autowired
	EventRepository eventRepository;
	@Autowired
	ParentRepository parentRepository;
	@Autowired
	CagnotteRepository cagnotteRepository;
	@Autowired
	ParentServiceImpl ps ;
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
		
		return eventRepository.save( E);
	}

	@Override
	public List<Event> retrieveAllEvents() {
		/*List<Event> events = (List<Event>) eventRepository.findAll();
		for (Event event :  events){
			L.info("event +++ : " + event);
		}
		return   events ;*/
		return (List<Event>) eventRepository.findAll();
	}

	@Override
	public Optional<Event> retrieveEvents(String id) {
		Optional<Event> u = eventRepository.findById(Long.parseLong(id));
		return  u ;
		
	}

	public static Logger getL() {
		return L;
	}
	
/*	public void parentJoinEvent(Long idEvent,  Long id) {
		
    	  
    	if   
    	    ( parentRepository.findById(id).isPresent())
    	{
    	 Parent parententity =   parentRepository.findById(id).get();
    	 Event    eventEntity = eventRepository.findById(idEvent).get();
    	 System.out.println(eventEntity);
    	 System.out.println(parententity);
    
    	  parententity.getEvents().add(eventEntity);
    	  System.out.println(parententity);
    	 // ps.updateParent(parententity);
    	  //parententity.setid(id);
    	 //List <Event> evts = parententity.getEvents();
    	 // evts.add(eventEntity);
    	 // parententity.setEvents(evts);
    	  //System.out.println("saving..");
    	  parententity.getEvents().add(eventEntity);
    	  parentRepository.save(parententity);
    	 //eventEntity.getParents().add(parententity);
    	 //eventRepository.save(eventEntity);
 	    
 	    //eventEntity.getParents().add(parententity);
    	}
    	 else 
    		 System.out.println(" id is not exist ");
    	
			
	}*/
	   @Transactional
	public void parentJoinEvent(Long idEvent,  Long id) {
		
    	  
    	if   
    	    ( parentRepository.findById(id).isPresent())
    	{
    	 Parent parententity =   parentRepository.findById(id).get();
    	 
    	 Event    eventEntity = eventRepository.findById(idEvent).get();
 	    
 	    eventEntity.getParents().add(parententity);
    	}
    	 else 
    		 System.out.println(" id is not exist ");
    	
			
	}

 /*    @Transactional
	public void cancelUserAttendance(Long idEvent,  Long id) {
		 
			Parent parentEntity= parentRepository.findById(id).get();
			
			Event    eventEntity = eventRepository.findById(idEvent).get();
			
			parentEntity.getEvents().remove( eventEntity);
			//parentRepository.save(parentEntity);
			
			eventRepository.save(eventEntity);
		
	}
*/
     @Transactional
	public void AffecterCagnotteAEvent(String idCagnotte, String idEvent) {
		
		  Cagnotte cagnotteEntity = cagnotteRepository.findById(Long.parseLong(idCagnotte)).get();
		
		  Event    eventEntity = eventRepository.findById(Long.parseLong(idEvent)).get();
		  
		  
		  eventEntity.setCagnotte(cagnotteEntity);
		  
		  eventRepository.save(eventEntity);
		
	}

    @Override
 	public Map<String, String> getNbrParticipants(Long idEvent) {
 		HashMap<String, String> map = new HashMap<>();
 		Optional<Event> ev = retrieveEvents(idEvent+"");
 		if (ev.isPresent()){
 			long nbParticipants= eventRepository.getNbrParticipants(idEvent);
 			double totalCagnotte = ev.get().getCagnotte().getAmount()*nbParticipants ;
 			map.put("Nombre des participants", nbParticipants+"");
 			map.put("Total cagnotte", totalCagnotte+"");
 			return map;
 		}
 		return map ;
 	}

     @Override
 	public Map<String, Object> getMaxCagnotte() {
 		HashMap<String, Object> map = new HashMap<>();
 		List<Event> events = retrieveAllEvents();
 		Event event = new Event();
 		double max=0 ;
 		double totalCagnotte=0 ;
 		long nbParticipants = 0 ;
 		for(Event e:events){ 			
 		nbParticipants= eventRepository.getNbrParticipants(e.getidEvent());
 			totalCagnotte = nbParticipants*e.getCagnotte().getAmount() ;
 			System.out.println("totalCagnotte"+totalCagnotte);
 			if (totalCagnotte>max){
 				max = totalCagnotte ;
 				event=e ;
 			} 		
 		}
 		
 		map.put("Event", event);
		map.put("Max cagnotte", max+"");
 		return map ;
 	}

		 
		  
	}


	
	
		
	

	
	
	




