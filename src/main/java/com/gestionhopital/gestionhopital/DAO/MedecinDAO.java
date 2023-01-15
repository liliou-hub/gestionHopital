package com.gestionhopital.gestionhopital.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionhopital.gestionhopital.models.Medecin;
import com.gestionhopital.gestionhopital.models.Rdv;

@Repository
public interface MedecinDAO extends CrudRepository<Medecin, Long>{
	List<Medecin> findByNom(String Nom);
	List<Medecin> findByRdv(Rdv rdv);
}
