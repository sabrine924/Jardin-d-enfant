package com.esprit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Reclamation;

@Repository
public interface ReclamationRepository  extends JpaRepository<Reclamation, Long> {

}
