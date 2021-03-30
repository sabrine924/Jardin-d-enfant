package com.esprit.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.project.entity.Rdv;
import com.esprit.project.service.IGestionRdv;
import com.sun.el.parser.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RdvServiceImplAddTest {
	
	
	@Autowired 
	IGestionRdv rdv;
	
	@Test
	public void test() throws ParseException, java.text.ParseException {
		Rdv rdv1 = new Rdv(1,"a","b","c","d");
		rdv.addRdv(rdv1);
	}

}