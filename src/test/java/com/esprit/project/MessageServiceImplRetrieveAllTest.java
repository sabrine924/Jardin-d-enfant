package com.esprit.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;





import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.project.service.IGestionMessage;




@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImplRetrieveAllTest {
	
	@Autowired 
	IGestionMessage message;
	
	@Test
	public void test() {
		message.retrieveAllMessages();
	}
	
}
