package com.esprit.project.service;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.project.entity.Rdv;
import com.esprit.project.entity.User;
import com.esprit.project.repository.RdvRepository;



@Service
public class GestionRdvImpl implements IGestionRdv{

	@Autowired
	RdvRepository rdvrepository;
	@Autowired
	UserServiceImpl userServiceImpl;
	private static final Logger L = LogManager.getLogger(GestionRdvImpl.class);
	
	@Override
	public List<Rdv> retrieveAllRdvs() {
		List<Rdv> rdvs = (List<Rdv>) rdvrepository.findAll();
		for (Rdv rdv : rdvs){
			L.info("Rdv :" + rdv);
		}
		return rdvs;
	}

	@Override
	public Rdv addRdv(Rdv rdv) {
		return rdvrepository.save(rdv);
	}

	public void store (Rdv rdv, Long userId){
		User user = userServiceImpl.findById(userId);
		Rdv rdv2 = new Rdv(rdv.getDate(), rdv.getSubject(), user);
		rdvrepository.save(rdv2);
		
	}
	
	@Override
	public void deleteRdv(String idRdv) {
		long id1 = Long.parseLong(idRdv);
		rdvrepository.deleteById(id1);

	}

	@Override
	public Rdv updateRdv(Rdv rdv) {
		return rdvrepository.save(rdv);
		}

	@Override
	public Optional<Rdv> retrieveRdv(String idRdv) {
		Optional<Rdv> rdv = rdvrepository.findById(Long.parseLong(idRdv));
		L.info("rdv :" + rdv);
		return rdv;
	}
	
	public Rdv findById(Long id) {
		Optional<Rdv> result = rdvrepository.findById(id);
		Rdv rdv = null;
		
		if(result.isPresent()) {
			 rdv = result.get();
		}
		else {
			throw new RuntimeException("cannot find the rdv" + id);
		}
		return rdv;
	}

	@Override
	public Rdv gestionRdv(Long rdv_id) {
		return this.findById(rdv_id);
	}

	/*@Override
	public void store(Long userId, Rdv addRdv) {
		// TODO Auto-generated method stub
		
	}*/

	

}
