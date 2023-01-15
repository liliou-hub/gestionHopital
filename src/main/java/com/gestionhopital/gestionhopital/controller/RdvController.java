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
import com.gestionhopital.gestionhopital.models.Rdv;
import com.gestionhopital.gestionhopital.service.RdvService;



@RestController
@RequestMapping(path = "/api/rdvs")
public class RdvController {
	
	@Autowired
	private RdvService rdvService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Rdv>>  getRdvs(){
		
		try {
			List<Rdv> rdvs =  rdvService.getRdvs();
			return new ResponseEntity<>(rdvs, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Rdv>  saveRdv(@RequestBody Rdv rdv) {
		try {
			return new ResponseEntity<>(rdvService.saveRdv(rdv), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Rdv> getRdvByID(@PathVariable Long id) {
		try {
			Rdv _rdv = rdvService.getRdvByID(id);
			if(_rdv != null) {
				return new ResponseEntity<>(_rdv, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path = "/patient")
	public ResponseEntity<List<Rdv>> getRdvByPatient(@RequestBody Patient patient){
	try {
	return new ResponseEntity<List<Rdv>>(rdvService.getRdvByPatient(patient),HttpStatus.OK);
	} catch (Exception e) {
			// TODO: handle exception
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Rdv>  updateRdv(@PathVariable Long id,@RequestBody Rdv rdv) {
		try {
			return new ResponseEntity<Rdv>(rdvService.updateRdv(id, rdv), HttpStatus.OK) ;
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping(path = "/{id}")
	 public void deleteRdvByID(@PathVariable Long id) {
		  rdvService.deleteByID(id);
	 }
	 
	@DeleteMapping(path = "/")
	 public void deleteRdvs() {
		 rdvService.deleteRdvs();
	 }
}
