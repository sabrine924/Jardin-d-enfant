package com.esprit.project;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.project.entity.Parent;
import com.esprit.project.service.IParentService;
//import com.esprit.project.service.ParentServiceImpl;
import com.sun.el.parser.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentServiceImplAddTest {
	
	//private static final Logger l = LogManager.getLogger(ParentServiceImpl.class);
	@Autowired 
	IParentService parent;
	
	@Test
	public void test() throws ParseException, java.text.ParseException {
		Parent parent1 = new Parent(1,"sabrine","hmidi",93147141,"sabrine.hmidi@esprit.tn", "kairouan",
				"lamis", "zaghdoudi", "5", "s");
		parent.addParent(parent1);
		parent1 = new Parent(2,"oumayma","benrhayem",93147141,"oumayma.benrhaiem@esprit.tn", "Nabeul",
				"jouri", "zaghdoudi", "5", "s");
		parent.addParent(parent1);
		parent1 = new Parent(3,"maryem","Gomri",93147141,"maryem.gomri@esprit.tn", "Tunis",
				"aziz", "abidi", "5", "s");
		parent.addParent(parent1);
		parent1 = new Parent(4,"hechmi","abidi",93147141,"hechmi.abidi@gmail.com", "SidiBouzid",
				"saja", "abidi", "5", "s");
		parent.addParent(parent1);
	}

}
