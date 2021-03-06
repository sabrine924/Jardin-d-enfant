package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import com.esprit.project.entity.Administrator;
import com.esprit.project.entity.Profile;
//import com.esprit.project.repository.AdministratorRepository;
import com.esprit.project.repository.ProfileRepository;



@Service
public class ProfileServiceImpl implements IProfileService{
	
	
	@Autowired
	private ProfileRepository profileRepository;
	
	private static final Logger l = LogManager.getLogger(ProfileServiceImpl.class);
	
	@Override
	public List<Profile> retrieveAllProfiles(){
		List<Profile> profiles = (List<Profile>) profileRepository.findAll();
		for (Profile profile : profiles){
			l.info("Profile :" + profile);
		}
		return profiles;
	}
	@Override
	public Profile addProfile(Profile profile){
		return profileRepository.save(profile);
		
	}
	@Override
	public void deleteProfile(String id){
		long id1 = Long.parseLong(id);
		profileRepository.deleteById(id1);
	}
	@Override
	public Profile updateProfile(Profile profile){
		return profileRepository.save(profile);
	}
	@Override
	public Optional<Profile> retrieveProfile(String id){
		Optional<Profile> profile = profileRepository.findById(Long.parseLong(id));
		l.info("Profile :" + profile);
		return profile;
	}
}
