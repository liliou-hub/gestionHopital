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

import com.gestionhopital.gestionhopital.models.Patient;
import com.gestionhopital.gestionhopital.models.Rdv;
import com.gestionhopital.gestionhopital.service.PatientService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PatientControllerTest {
	
	@InjectMocks
	private PatientController patientController;
	
	@Mock
	private PatientService patientService;
	
	public void getPatient_withoutException_Test() {
		
//		Given
		List<Patient> list = new ArrayList<>();
		
		Patient firstPatient = new Patient();
		Patient secondPatient = new Patient();
		
		list.add(firstPatient);
		list.add(secondPatient);
		
		
//		When 
		Mockito.when(patientService.getPatients()).thenReturn(list);
		ResponseEntity<List<Patient>> patientList = patientController.getPatients();
		
		
//		Then
		assertEquals(HttpStatus.OK, patientList.getStatusCode());

	}
	
	@Test
	public void getPatients_withException_Test() {
		
		when(patientService.getPatients()).thenThrow(new NullPointerException("Error occurred"));
		Assert.assertTrue(patientController.getPatients().getStatusCode() ==  HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	public void getPatientByID() throws Exception{
		
//		Given
		Patient patient = new Patient();
		patient.setId(2L);

//		When
		Mockito.when(patientService.getPatientByID(2L)).thenThrow(new NullPointerException("Error occured"));
		ResponseEntity<Patient> response = patientController.getPatientByID(2L);
		
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());	
	}
	
public void deleteByID() throws Exception{
		
//		Given
		Patient patient = new Patient();
		patient.setNom("Monsieur Riad");
		patient.setNumSecu(null);
		
		
//		When
		patientController.deletePatientByID(30L);
		ResponseEntity<Patient> retrievedRdv = patientController.getPatientByID(patient.getId());
		
		//Then
		assertThat(retrievedRdv.getBody()).isNull();
	}

		@Test
		public void  deletePatients() throws Exception {
	
			Patient patient = new Patient();
			patient.setNom("Monsieur Riad");
			patient.setNumSecu(null);
	
		patientController.deletePatients();
		ResponseEntity<Patient> retrievedPatient = patientController.getPatientByID(patient.getId());
	
		//Then
	
		assertThat(retrievedPatient.getBody()).isNull();
	
}

}
