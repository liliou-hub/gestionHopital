package com.gestionhopital.gestionhopital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionhopital.gestionhopital.DAO.PatientDAO;
import com.gestionhopital.gestionhopital.models.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	
	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	public List<Patient> getPatients() {
		
		List<Patient> PATIENT= (List<Patient>) patientDAO.findAll();
		if(!PATIENT.isEmpty()) {
			return PATIENT;
		}
		else {	
			return null;
		}
	}

	
	@Override
	public Patient savePatient(Patient patient) {
		Patient _patient=new Patient();
		_patient.setNom(patient.getNom());
		_patient.setNumSecu(patient.getNumSecu());
		patientDAO.save(_patient);
		
		return _patient;
	}

	@Override
	public Patient getPatientByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient updatePatient(Long id, Patient book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByID(Long id) {
		patientDAO.deleteById(id);
		
	}

	@Override
	public void deletePatients() {
		patientDAO.deleteAll();
	}
		
	

}
