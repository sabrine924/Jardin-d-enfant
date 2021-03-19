package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.User;
import com.esprit.project.repository.UserRepository;



@Service
public class UserServiceImpl implements IUserService{
	
	
	@Autowired
	private UserRepository userRepository;
	
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers(){
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users){
			l.info("user :" + user);
		}
		return users;
	}
	@Override
	public User addUser(User u){
		return userRepository.save(u);
		
	}
	@Override
	public void deleteUser(String id){
		long id1 = Long.parseLong(id);
		userRepository.deleteById(id1);
	}
	@Override
	public User updateUser(User u){
		return userRepository.save(u);
	}
	@Override
	public Optional<User> retrieveUser(String id){
		Optional<User> user = userRepository.findById(Long.parseLong(id));
		l.info("user :" + user);
		return user;
	}
}
