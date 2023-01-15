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

import com.gestionhopital.gestionhopital.models.Rdv;
import com.gestionhopital.gestionhopital.service.RdvService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class RdvControllerTest {

	@InjectMocks
	private RdvController rdvController;
	
	@Mock
	private RdvService rdvService;
	
	@Test
	public void getRdv_withoutException_Test() {

//		Given
		List<Rdv> list = new ArrayList<>();
		
		Rdv firstRdv = new Rdv();
		Rdv secondRdv = new Rdv();
		
		list.add(firstRdv);
		list.add(secondRdv);
		
//		When
		Mockito.when(rdvService.getRdvs()).thenReturn(list);
		ResponseEntity<List<Rdv>> rdvList = rdvController.getRdvs();
		
//		Then
		assertEquals(HttpStatus.OK, rdvList.getStatusCode());
		
	}
	
	@Test
	public void getRdvs_withException_Test() {
		
		when(rdvService.getRdvs()).thenThrow(new NullPointerException("Error occurred"));
		Assert.assertTrue(rdvController.getRdvs().getStatusCode() ==  HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	public void getRdvByID() throws Exception{
		
//		Given
		Rdv rdv = new Rdv();
		rdv.setId(2L);

//		When
		Mockito.when(rdvService.getRdvByID(2L)).thenThrow(new NullPointerException("Error occured"));
		ResponseEntity<Rdv> response = rdvController.getRdvByID(2L);
		
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());	
	}
	
	public void deleteByID() throws Exception{
		
//		Given
		Rdv rdv = new Rdv();
		rdv.setId(30L);
		rdv.setAdresse("Tenon");
		rdv.setDate(null);
		
//		When
				rdvController.deleteRdvByID(30L);
				ResponseEntity<Rdv> retrievedRdv = rdvController.getRdvByID(rdv.getId());
				
				//Then
				assertThat(retrievedRdv.getBody()).isNull();
	}
	
	@Test
	public void  deleteRdvs() throws Exception {
		
		Rdv rdv = new Rdv();
		rdv.setId(30L);
		rdv.setAdresse("Tenon");
		rdv.setDate(null);
		
		rdvController.deleteRdvs();
		ResponseEntity<Rdv> retrievedRdv = rdvController.getRdvByID(rdv.getId());
		
		//Then
		
		assertThat(retrievedRdv.getBody()).isNull();
		
	}
	
}
