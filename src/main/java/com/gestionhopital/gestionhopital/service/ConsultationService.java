package com.gestionhopital.gestionhopital.service;

import java.util.List;



import com.gestionhopital.gestionhopital.models.Consultation;
import com.gestionhopital.gestionhopital.models.Rdv;


public interface ConsultationService {
	
	List<Consultation> getConsultations();
	
	Consultation saveConsultation(Consultation consultation);
	
	Consultation getConsultationByID(Long id);
	
	Consultation updateConsultation(Long id,Consultation consultation);
	
	
	void deleteByID(Long id);
	
	void deleteConsultations();
//
//	List<Consultation> getConsultationByIdRdv(Rdv rdv);
//
//	Consultation getConsultationByIdRdv(Long idRdv);
	
	

}
