package com.gestionhopital.gestionhopital.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="consultation")
public class Consultation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsultation;
	
	@Column(name="diagnostic")
	private String Diagnostic;
	
	@OneToOne(mappedBy = "consultation",fetch = FetchType.LAZY)
	private Rdv rdv;
	
	
	
	
	public Consultation(String diagnostic, Rdv rdv) {
		
		this.Diagnostic = diagnostic;
		this.rdv = rdv;
	}
	
	
	@JsonIgnore
	public Rdv getRdv() {
		return rdv;
	}



	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}



	public Consultation() {
		
	}



	public Long getIdConsulation() {
		return idConsultation;
	}
	public void setIdConsulation(Long idConsulation) {
		this.idConsultation = idConsulation;
	}
	public String getDiagnostic() {
		return Diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		Diagnostic = diagnostic;
	}
	
	
}
