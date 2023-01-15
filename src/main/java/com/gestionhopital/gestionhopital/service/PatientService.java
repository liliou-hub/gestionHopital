package com.gestionhopital.gestionhopital.service;

import java.util.List;

import com.gestionhopital.gestionhopital.models.Patient;



public interface PatientService {
	
	List<Patient> getPatients();
	
	Patient savePatient(Patient patient);
	
	Patient getPatientByID(Long id);
	
	Patient updatePatient(Long id,Patient patient);
	
	
	void deleteByID(Long id);
	
	void deletePatients();
	

}
