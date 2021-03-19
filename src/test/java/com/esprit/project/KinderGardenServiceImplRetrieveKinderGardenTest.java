package com.esprit.project;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.project.service.IKinderGardenService;
//import com.esprit.project.service.IParentService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class KinderGardenServiceImplRetrieveKinderGardenTest {
	
	//private static final Logger l = LogManager.getLogger(ParentServiceImpl.class);
	@Autowired 
	IKinderGardenService kinderGarden;
	
	@Test
	public void test() {
		kinderGarden.retrieveKinderGarden("1");
	}

}
