package com.esprit.project.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Profile;





@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
	
}
