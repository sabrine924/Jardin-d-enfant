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
		Parent parent1 = new Parent(1,"a","b",22325,"c", "d",
				"e", "f", "5", "g");
		parent.addParent(parent1);
	}

}
