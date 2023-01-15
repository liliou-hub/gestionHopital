package com.gestionhopital.gestionhopital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhopital.gestionhopital.DAO.ConsultationDAO;
import com.gestionhopital.gestionhopital.models.Consultation;
import com.gestionhopital.gestionhopital.models.Rdv;

@Service
public class ConsultationServiceImpl  implements ConsultationService{

	@Autowired
	private ConsultationDAO consultationDAO;
	
	@Override
	public List<Consultation> getConsultations() {
		List<Consultation> consultations = (List<Consultation>) consultationDAO.findAll();
		if(!consultations.isEmpty()) {
			return consultations;
		} 	
		return null;
	}

	@Override
	public Consultation saveConsultation(Consultation consultation) {
		
		
//		Consultation consult = new Consultation();
//		consult.setDiagnostic(consultation.getDiagnostic());
	
		return consultationDAO.save(new Consultation(consultation.getDiagnostic(),consultation.getRdv()));
		
	}

	@Override
	public Consultation getConsultationByID(Long id) {
		
		Optional<Consultation> consultation = consultationDAO.findById(id);
		if(consultation.isPresent()) {
			return consultation.get();
		}
		return null;
	}

	@Override
	public Consultation updateConsultation(Long id, Consultation consultation) {
		Optional<Consultation> retrievedConsultation = consultationDAO.findById(id);
		Consultation consult = retrievedConsultation.get();
		consult.setDiagnostic(consultation.getDiagnostic());
		
		consultationDAO.save(consult);
		return consult;		
	}


	@Override
	public void deleteByID(Long id) {
		consultationDAO.deleteById(id);
		
	}

	@Override
	public void deleteConsultations() {
		consultationDAO.deleteAll();
		
	}

//	@Override
//	public List<Consultation> getConsultationByIdRdv(Rdv rdv) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Consultation getConsultationByIdRdv(Long idRdv) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
