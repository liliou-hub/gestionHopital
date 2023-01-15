package com.gestionhopital.gestionhopital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gestionhopital.gestionhopital.models.Medecin;
import com.gestionhopital.gestionhopital.service.MedecinService;

@RestController
@RequestMapping(path="/api/medecins")
public class MedecinController {
	
	@Autowired
	private MedecinService medecinService;
	

    @GetMapping(path = "/")
    public ResponseEntity<List<Medecin>>  getMedecins(){

        try {
            List<Medecin> medecins = medecinService.getMedecins();
            return new ResponseEntity<>(medecins, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	
	@PostMapping(path="/")
	public ResponseEntity<Medecin> saveMedecin(@RequestBody Medecin medecin){
		try {
			return new ResponseEntity<>(medecinService.saveMedecin(medecin), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Medecin> getMedecinByID(@PathVariable Long id) {
		try {
			Medecin _medecin = medecinService.getMedecinByID(id);
			if(_medecin != null) {
				return new ResponseEntity<>(_medecin, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Medecin>  updateMedecin(@PathVariable Long id,@RequestBody Medecin medecin) {
		try {
			return new ResponseEntity<Medecin>(medecinService.updateMedecin(id, medecin), HttpStatus.OK) ;
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping(path = "/{id}")
	 public void deleteMedecinByID(@PathVariable Long id) {
		  medecinService.deleteByID(id);
	 }
	 
	@DeleteMapping(path = "/")
	 public void deleteMedecins() {
		 medecinService.deleteMedecins();
	 }
	
}
