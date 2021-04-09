package com.esprit.project.service;

import java.util.List;

import com.esprit.project.entity.Reclamation;



public interface IReclamationService {
	Reclamation addReclamation(Reclamation r);
	Reclamation updateReclamation(Reclamation r);
	List<Reclamation> retrieveAllReclamations();
	 void    deleteReclamationById(String id);



}
