package com.esprit.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;

import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.project.entity.Event;
import com.esprit.project.service.IEventService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceImplTest {
	private static final Logger L = LogManager.getLogger(EventServiceImplTest.class);
	public static Logger getL() {
		return L;
	}
	
	@Autowired
	IEventService us;
	@Test
	public void testAddEvents() throws ParseException, Exception{
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = dateFormat.parse("2022-02-06");
	Event E = new Event((long) 1 , "evenement sport" , " sport pour  de  nos enfants ",05, 07, date, 60,  "eventsX" , "Ariana", "img1");
	us.addEvents(E);
	}
	@Test
	public void testDeleteEventsById(){
		us.deleteEventById("3");
	}
	@Test
	public void testretrieveEvents(){
		us.retrieveAllEvents();
	}
	@Test 
	public void testupdateEvents() throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("1995-07-02");
		Event E = new Event( new Long(2), "evenemnt traditionnel ","tradition",5, 04, d, 60, "tunisie",  "Kairouan","img2");
		us.update(E);
	}
	@Test
	public void testRetrieveEvents(){
		us.retrieveEvents("2");
	}
	@Test 
	public void testparentJoinEvent(){
		
	}
	
	
    }
