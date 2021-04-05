package com.esprit.project.repository;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Event;



@Repository
public interface EventRepository extends  CrudRepository<Event, Long > {

	@Query(value = "SELECT COUNT(*) FROM t_events_parents e where e.events_id_event= :eventId", nativeQuery = true)
	long getNbrParticipants(@Param("eventId") long eventId);
	

	

}
