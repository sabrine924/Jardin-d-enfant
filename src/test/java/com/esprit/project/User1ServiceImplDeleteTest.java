package com.esprit.project;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


//import com.esprit.project.service.UserServiceImpl;
import com.esprit.project.service.IUserService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class User1ServiceImplDeleteTest {
	
	//private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	@Autowired 
	IUserService us;
	
	@Test
	public void test() {
		us.deleteUser("2");
	}

}
