package com.gestionhopital.gestionhopital.service;

//import java.awt.print.Medecin;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhopital.gestionhopital.DAO.MedecinDAO;
import com.gestionhopital.gestionhopital.models.Medecin;

@Service
public class MedecinServiceImpl  implements MedecinService{
	
	@Autowired
	private MedecinDAO medecinDAO;
	
	@Override
	public List<Medecin> getMedecins(){
		
		List<Medecin> MEDECINS= (List<Medecin>) medecinDAO.findAll();
		if(!MEDECINS.isEmpty()) {
			return MEDECINS;
		}
		else {
			return null;
		}
	}
	
	@Override
	public Medecin saveMedecin(Medecin medecin) {
		
		Medecin _medecin= new Medecin();
		_medecin.setNom(medecin.getNom());
		_medecin.setSpecialite(medecin.getSpecialite());
		medecinDAO.save(_medecin);
		return _medecin;
	}
	
	
	@Override
	public Medecin getMedecinByID(Long id) {
		
		Optional<Medecin> retrievedMedecin= medecinDAO.findById(id);
		if(retrievedMedecin.isPresent()) {
			return retrievedMedecin.get();
		}
		else {
			return null;
		}
	}
	
	@Override
	public Medecin updateMedecin(Long id, Medecin medecin) {
		Optional<Medecin> retrievedMedecin = medecinDAO.findById(id);
		
		Medecin _medecin=retrievedMedecin.get();
		
		_medecin.setNom(medecin.getNom());
		_medecin.setSpecialite(medecin.getSpecialite());
		
		medecinDAO.save(_medecin);
		return _medecin;
		
	}
	
	@Override
	public void deleteByID(Long id) {
		medecinDAO.deleteById(id);
	}

	@Override
	public void deleteMedecins() {
		medecinDAO.deleteAll();
	}
}
