package com.esprit.project;


import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import com.esprit.project.entity.Parent;
import com.esprit.project.entity.Profile;
//import com.esprit.project.service.IParentService;
import com.esprit.project.service.IProfileService;
//import com.esprit.project.service.IProfileService;
//import com.esprit.project.service.ParentServiceImpl;
import com.sun.el.parser.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileServiceImplAddTest {
	
	//private static final Logger l = LogManager.getLogger(ParentServiceImpl.class);
	@Autowired 
	IProfileService profile;
	
	@Test
	public void test() throws ParseException, java.text.ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("1997-07-20");
		Profile profile1 = new Profile(1,2, date, 22,"adress", "location");
		profile.addProfile(profile1);
	}

}
