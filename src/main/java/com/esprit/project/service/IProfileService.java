package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

//import com.esprit.project.entity.Administrator;
import com.esprit.project.entity.Profile;






public interface IProfileService {

	List<Profile> retrieveAllProfiles();
	Profile addProfile(Profile profile);
	void deleteProfile(String id);
	Profile updateProfile(Profile profile);
	Optional<Profile> retrieveProfile(String id);
}
