package com.esprit.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.project.service.IUserService;
//import com.esprit.project.service.UserServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplRetrieveAllTest {
	
	//private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	@Autowired 
	IUserService us;
	
	@Test
	public void test() {
		us.retrieveAllUsers();
	}
	
}
