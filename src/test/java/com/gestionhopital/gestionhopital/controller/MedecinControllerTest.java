package com.gestionhopital.gestionhopital.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gestionhopital.gestionhopital.models.Medecin;
import com.gestionhopital.gestionhopital.service.MedecinService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class MedecinControllerTest {
	
	@InjectMocks
	private MedecinController medecinController=new MedecinController();

	@Mock
	private MedecinService medecinService;
	
	@Test
	public void getMedecins_withoutexception_Test() {
		
		// First  : Given
		List<Medecin> list = new ArrayList<>();
		
		Medecin firstMedecin = new Medecin();
		Medecin secondMedecin = new Medecin();
		
		list.add(firstMedecin);
		list.add(secondMedecin);
		
		// Second Step : When
		Mockito.when(medecinService.getMedecins()).thenReturn(list);
		ResponseEntity<List<Medecin>> medecinlist = medecinController.getMedecins();
		
		// Third Step : Then
		assertEquals(HttpStatus.OK, medecinlist.getStatusCode());
		
	}
	@Test
	public void getMedecins_withException_Test() {
		when(medecinService.getMedecins()).thenThrow(new NullPointerException("error occured"));
		Assert.assertTrue(medecinController.getMedecins().getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void getMedecinByID() throws Exception{
		
//		given
		Medecin medecin = new Medecin();
		
		medecin.setId(2L);
		
		
//		when
		when(medecinService.getMedecinByID(2L)).thenReturn(medecin);
		ResponseEntity<Medecin> response = medecinController.getMedecinByID(2L);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
//	 Test d'une création d'un medecin
	@Test
	public void createMedecin_WithoutException() throws Exception{
		
//		Given
		
		Medecin medecin = new Medecin();
		medecin.setId(3L);
		medecin.setNom("Docteur Vincent");
		medecin.setSpecialite("Neurologue");
		
//		When
		when(medecinService.saveMedecin(medecin)).thenReturn(medecin);
		ResponseEntity<Medecin> resp = medecinController.saveMedecin(medecin);
		
//		Then
		
		assertThat(resp.getBody().getId()).isGreaterThan(0);

	}
	
//	delete un medecin de la BDD
	
	public void deleteByID() throws Exception{
		
//		Given
		Medecin medecin = new Medecin();
		medecin.setId(3L);
		medecin.setNom("Dubrasquet Lannot");
		medecin.setSpecialite("Ophtalmologue");
		
		//When
		medecinController.deleteMedecinByID(3L);
		ResponseEntity<Medecin> retrievedMedecin = medecinController.getMedecinByID(medecin.getId());;
		
		//Then
		assertThat(retrievedMedecin.getBody()).isNull();
	}
	
	
	
	
}
