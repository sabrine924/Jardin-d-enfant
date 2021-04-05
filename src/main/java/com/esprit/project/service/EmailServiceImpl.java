package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esprit.project.entity.Email;
import com.esprit.project.entity.User;
import com.esprit.project.repository.UserRepository;
import com.esprit.project.repository.EmailRepository;

@Controller
public class EmailServiceImpl implements IGestionMailing{

	@Autowired
	UserRepository userRepository;
	@Autowired 
	EmailRepository emailRepository;
	
	private static final Logger l = LogManager.getLogger(EmailServiceImpl.class);

	@Autowired
	private JavaMailSender mailSenderObj;

	@GetMapping("/")
	public String welcome() {

		return "welcome";
	}

	@RequestMapping(value = { "/allusers" }, method = RequestMethod.GET)
	public String viewUsers(Model model) {

		List<User> allUsers = userRepository.findAll();
		model.addAttribute("users", allUsers);
		return "userlist";

	}
	
	public ResponseEntity<User> retrieveUser(String user_email){
		Optional<User> user = userRepository.findById(Long.parseLong(user_email));
		l.info("user :" + user);
		return new ResponseEntity<User>(HttpStatus.OK);

	}
	@Override
	public void sendmail(User user) {

		final String emailToRecipient = user.getEmail();
		final String emailSubject = "Succesfully Registration";

		final String emailMessage1 = "<html> <body> <p>Dear Sir/Madam,</p><p>You have succesfully Registered with our Services"
				+ "<br><br>"
				+ "<table border='1' width='300px' style='text-align:center;font-size:20px;'><tr> <td colspan='2'>"
				+ "</td></tr><tr><td>Name</td><td>" + user.getFirstName() + "</td></tr><tr><td>Address</td><td>"
				+ user.getAdress() + "</td></tr><tr><td>Email</td><td>" + user.getEmail()
				+ "</td></tr></table> </body></html>";

		mailSenderObj.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				mimeMsgHelperObj.setTo(emailToRecipient);
				mimeMsgHelperObj.setText(emailMessage1, true);

				mimeMsgHelperObj.setSubject(emailSubject);

			}
		});

	}
	@Override
	public List<Email> retrieveAllEmails() {
		List<Email> emails = (List<Email>) emailRepository.findAll();
		for (Email email : emails){
			l.info("Email :" + email);
		}
		return emails;
		}

	@Override
	public Optional<Email> retrieveEmail(String id) {
		Optional<Email> email = emailRepository.findById(Long.parseLong(id));
		l.info("email :" + email);
		return email;
	}



}
