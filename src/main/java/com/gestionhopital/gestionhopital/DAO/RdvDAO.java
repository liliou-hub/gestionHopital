package com.gestionhopital.gestionhopital.DAO;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionhopital.gestionhopital.models.Patient;
import com.gestionhopital.gestionhopital.models.Rdv;

@Repository
public interface RdvDAO extends CrudRepository<Rdv, Long>{
	List<Rdv> findByPatient(Patient patient);	

}
