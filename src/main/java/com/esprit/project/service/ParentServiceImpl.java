package com.esprit.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Parent;
import com.esprit.project.repository.ParentRepository;




@Service
public class ParentServiceImpl implements IParentService{
	
	
	@Autowired
	
	 ParentRepository ParentRepository;
	private static final Logger l = LogManager.getLogger(ParentServiceImpl.class);
	
	@Override
	public List<Parent> retrieveAllParents(){
		List<Parent> parents = (List<Parent>) ParentRepository.findAll();
		for (Parent parent : parents){
			l.info("Parent :" + parent);
		}
		return parents;
	}
	@Override
	public Parent addParent(Parent parent){
		return ParentRepository.save(parent);
		
	}
	@Override
	public void deleteParent(String id){
		long id1 = Long.parseLong(id);
		ParentRepository.deleteById(id1);
	}
	@Override
	public Parent updateParent(Parent parent){
		return ParentRepository.save(parent);
	}
	@Override
	public Optional<Parent> retrieveParent(String id){
		Optional<Parent> parent = ParentRepository.findById(Long.parseLong(id));
		l.info("Parent :" + parent);
		return parent;
	}
}
