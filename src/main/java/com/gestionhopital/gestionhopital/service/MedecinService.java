package com.gestionhopital.gestionhopital.service;

import java.util.List;

import com.gestionhopital.gestionhopital.models.Medecin;

public interface MedecinService {
	
	List<Medecin> getMedecins();
	
	Medecin saveMedecin(Medecin medecin);
	
	Medecin getMedecinByID(Long id);
	
	Medecin updateMedecin(Long id,Medecin medecin);
	
	void deleteByID(Long id);
	
	void deleteMedecins();

}
