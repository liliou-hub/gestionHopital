package com.gestionhopital.gestionhopital.DAO;


import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionhopital.gestionhopital.models.Consultation;
import com.gestionhopital.gestionhopital.models.Rdv;

@Repository
public interface ConsultationDAO extends  CrudRepository<Consultation, Long>{
}
