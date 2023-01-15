package com.gestionhopital.gestionhopital.service;

import java.util.List;

import com.gestionhopital.gestionhopital.models.Patient;
import com.gestionhopital.gestionhopital.models.Rdv;

public interface RdvService {
	
	List<Rdv> getRdvs();
	
	Rdv saveRdv(Rdv rdv);
	
	Rdv getRdvByID(Long id);
	
	Rdv updateRdv(Long id,Rdv rdv);
	
	List<Rdv> getRdvByPatient(Patient patient);
	
	void deleteByID(Long id);
	
	void deleteRdvs();

//	Rdv saveRdv(Rdv rdv, Patient patient);
	

}
