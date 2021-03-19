package com.esprit.project;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.project.entity.Administrator;
//import com.esprit.project.service.AccountServiceImpl;
//import com.esprit.project.service.AdministratorServiceImpl;
import com.esprit.project.service.IAdministratorService;
import com.sun.el.parser.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorServiceImplAddTest {
	
	//private static final Logger l = LogManager.getLogger(AdministratorServiceImpl.class);
	@Autowired 
	IAdministratorService administrator;
	
	@Test
	public void test() throws ParseException, java.text.ParseException {
		Administrator admin = new Administrator(012,"youssef","benammar","mail",2);
		administrator.addAdministrator(admin);
	}

}
