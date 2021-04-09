package com.esprit.project.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Reclamation;
import com.esprit.project.repository.ReclamationRepository;




@Service

public class ReclamationService implements IReclamationService {
	@Autowired
	ReclamationRepository reclamationRepository;
private static final Logger L = LogManager.getLogger(ReclamationService.class);
@Override
public List<Reclamation> retrieveAllReclamations() {
	List<Reclamation> reclamations = (List<Reclamation>) reclamationRepository.findAll();
	for (Reclamation reclamation: reclamations) {
		L.info("reclamation : " + reclamation);
	}
	return reclamations;}

@Override
public Reclamation addReclamation(Reclamation r) {
	return reclamationRepository.save(r);
}

@Override
public Reclamation updateReclamation(Reclamation r) {
	return reclamationRepository.save(r);	
}

@Override
public void deleteReclamationById(String id) {

	 reclamationRepository.deleteById(Long.parseLong(id));
	
}

}


