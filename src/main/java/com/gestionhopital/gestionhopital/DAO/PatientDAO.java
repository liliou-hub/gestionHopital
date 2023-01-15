package com.gestionhopital.gestionhopital.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionhopital.gestionhopital.models.Medecin;
import com.gestionhopital.gestionhopital.models.Patient;
import com.gestionhopital.gestionhopital.models.Rdv;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Long> {
	List<Patient> findByNom(String nom);
	List<Patient> findByRdv(Rdv rdv);

}
