package com.gestionhopital.gestionhopital.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhopital.gestionhopital.DAO.ConsultationDAO;
import com.gestionhopital.gestionhopital.DAO.MedecinDAO;
import com.gestionhopital.gestionhopital.DAO.PatientDAO;
import com.gestionhopital.gestionhopital.DAO.RdvDAO;
import com.gestionhopital.gestionhopital.models.Patient;
import com.gestionhopital.gestionhopital.models.Rdv;

@Service
public class RdvServiceImpl implements RdvService {
	
	@Autowired
	private RdvDAO rdvDAO;
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private MedecinDAO medecinDAO;
	@Autowired
	private ConsultationDAO consultationDAO;

	@Override
	public List<Rdv> getRdvs() {
		List<Rdv> RDVS= (List<Rdv>) rdvDAO.findAll();
		if(!RDVS.isEmpty()) {
			return RDVS;
		
		}
		else {
			return null;
		}
	}

	@Override
	public Rdv saveRdv(Rdv rdv) {
		return rdvDAO.save(rdv);
	}
	
//	public Rdv saveRdv(Rdv rdv,Patient patient) {
//		Rdv _rdv = new Rdv();
//		_rdv.setDate(rdv.getDate());
//		_rdv.setAdresse(rdv.getAdresse());		
//		rdvDAO.save(_rdv);
//		return _rdv;
//	}

	@Override
	public Rdv getRdvByID(Long id) {
		Optional<Rdv> retrievedRdv = rdvDAO.findById(id);
		if(retrievedRdv.isPresent()) {
			return retrievedRdv.get();
		}else {
		return null;
		}
	}	
		
	@Override
	public Rdv updateRdv(Long id, Rdv rdv) {
	Optional<Rdv> retrievedRdv = rdvDAO.findById(id);
		
		Rdv _rdv = retrievedRdv.get();
		
		_rdv.setDate(rdv.getDate());
		_rdv.setAdresse(rdv.getAdresse());
	
		rdvDAO.save(_rdv);
		return _rdv;		
	}

	@Override
	public void deleteByID(Long id) {
		rdvDAO.deleteById(id);
		
	}

	@Override
	public void deleteRdvs() {
		rdvDAO.deleteAll();
		
	}

	@Override
	public List<Rdv>  getRdvByPatient(Patient patient) {
		 //TODO Auto-generated method stub
		List<Rdv> rdvs = rdvDAO.findByPatient(patient);
		if(!rdvs.isEmpty()) {
			return rdvs;
		}
		return null;
	}

}
