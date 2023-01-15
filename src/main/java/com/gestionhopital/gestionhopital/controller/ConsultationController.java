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

import com.gestionhopital.gestionhopital.models.Consultation;
import com.gestionhopital.gestionhopital.models.Patient;
import com.gestionhopital.gestionhopital.models.Rdv;
import com.gestionhopital.gestionhopital.service.ConsultationService;

@RestController
@RequestMapping(path="/api/consultations")
public class ConsultationController {
	
	@Autowired
	private ConsultationService consultationService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Consultation>> getConsultations(){
		try {
			List<Consultation> consults =  consultationService.getConsultations();
			return new ResponseEntity<>(consults, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path = "/{idConsultation}")
	public ResponseEntity<Consultation> getConsultationByid(@PathVariable Long idConsultation) {
		try {
			Consultation consult = consultationService.getConsultationByID(idConsultation);
			if(consult != null) {
				return new ResponseEntity<>(consult, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path="/")
	public ResponseEntity<Consultation> saveConsultation(@RequestBody Consultation consultation){
		try {
			return new ResponseEntity<>(consultationService.saveConsultation(consultation), HttpStatus.CREATED);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		}

	@PutMapping(path = "/{idConsultation}")
	public ResponseEntity<Consultation>  updateConsultation(@PathVariable Long idConsultation,@RequestBody Consultation consultation) {
		try {
			return new ResponseEntity<Consultation>(consultationService.updateConsultation(idConsultation, consultation), HttpStatus.OK) ;
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping(path = "/{idConsultation}")
	 public void deleteByIdConsultation(@PathVariable Long idConsultation) {
		  consultationService.deleteByID(idConsultation);
	 }
	 
	@DeleteMapping(path = "/")
	 public void deleteConsultations() {
		 consultationService.deleteConsultations();
	 }
}
