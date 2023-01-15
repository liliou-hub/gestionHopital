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

import com.gestionhopital.gestionhopital.models.Consultation;

import com.gestionhopital.gestionhopital.service.ConsultationService;


@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class ConsultationControllerTest {
	
	@InjectMocks
	private ConsultationController consultationController;
	
	@Mock
	private ConsultationService consultationService;
	
	@Test
	public void getConsultation_withoutException_Test() {

//		Given
		List<Consultation> list = new ArrayList<>();
		
		Consultation firstConsultation = new Consultation();
		Consultation secondConsultation = new Consultation();
		
		list.add(firstConsultation);
		list.add(secondConsultation);
		
//		When
		Mockito.when(consultationService.getConsultations()).thenReturn(list);
		ResponseEntity<List<Consultation>> consultationList = consultationController.getConsultations();
		
//		Then
		assertEquals(HttpStatus.OK, consultationList.getStatusCode());
		
	}
	
	@Test
	public void getConsultations_withException_Test() {
		
		when(consultationService.getConsultations()).thenThrow(new NullPointerException("Error occurred"));
		Assert.assertTrue(consultationController.getConsultations().getStatusCode() ==  HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	public void getConsultationByID() throws Exception{
			
//		Given
		Consultation consultation = new Consultation();
		consultation.setIdConsulation(null);

//		When
		Mockito.when(consultationService.getConsultationByID(2L)).thenThrow(new NullPointerException("Error occured"));
		ResponseEntity<Consultation> response = consultationController.getConsultationByid(2L);
		
//		Then
		assertEquals(HttpStatus.OK, response.getStatusCode());	
		}
	
	public void deleteByID() throws Exception{
			
//		Given
		Consultation consultation = new Consultation();
		consultation.setIdConsulation(null);
		consultation.setDiagnostic("Tout va bien");
			
//		When
		consultationController.deleteByIdConsultation(30L);
		ResponseEntity<Consultation> retrievedConsultation = consultationController.getConsultationByid(consultation.getIdConsulation());
					
//		Then
		assertThat(retrievedConsultation.getBody()).isNull();
	}
	
	@Test
	public void  deleteConsultations() throws Exception {
		
		Consultation consultation = new Consultation();
		consultation.setIdConsulation(null);
		consultation.setDiagnostic("Tout va bien\"");
		
		
		consultationController.deleteConsultations();
		ResponseEntity<Consultation> retrievedConsultation = consultationController.getConsultationByid(consultation.getIdConsulation());
		
		//Then
		
		assertThat(retrievedConsultation.getBody()).isNull();
		
	}
}
