package com.gestionhopital.gestionhopital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionhopital.gestionhopital.models.Patient;
import com.gestionhopital.gestionhopital.service.PatientService;

@RestController
@RequestMapping(path="/api/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping(path="/")
	public ResponseEntity<List<Patient>> getPatients(){
		try {
			List<Patient> patients = patientService.getPatients();
			return new ResponseEntity<>(patients, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		try {
			return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Patient> getPatientByID(@PathVariable Long id) {
		try {
			Patient _patient = patientService.getPatientByID(id);
			if(_patient != null) {
				return new ResponseEntity<>(_patient, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	


	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Patient>  updatePatient(@PathVariable Long id,@RequestBody Patient patient) {
		try {
			return new ResponseEntity<Patient>(patientService.updatePatient(id, patient), HttpStatus.OK) ;
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping(path = "/{id}")
	 public void deletePatientByID(@PathVariable Long id) {
		  patientService.deleteByID(id);
	 }
	 
	@DeleteMapping(path = "/")
	 public void deletePatients() {
		 patientService.deletePatients();
	 }
	
}
