package com.esprit.project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.project.entity.Offre;

public interface OffreRepository extends JpaRepository<Offre,Long>  {

@Query(value = "SELECT COUNT(*) FROM t_parent_offre_parent o  where offre_parent_id= :offreId", nativeQuery = true)
	int getNbrParticipants(@Param("offreId") long offreId);
@Query(value = "SELECT * FROM `t_offre` WHERE `type_offre` like '%"+":typeOffre"+"%'", nativeQuery = true)
	List<Offre> findOffreByType(@Param("typeOffre") String typeOffre);
//@Query("SELECT * FROM `t_offre` WHERE `type_offre` like '%:typeOffre%'")
//public List<Offre> filterByTypeOffre(@Param("typeOffre")TypeOffre typeOffre);


	


	
	
}
