package com.gestionhopital.gestionhopital.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="rdv")
public class Rdv implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="date")
	private LocalDate date;
	@Column(name="adresse")
	private String adresse;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idMed",referencedColumnName = "id")
	private Medecin medecin;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idPat",referencedColumnName = "id")
	private Patient patient;
	
	@OneToOne
	private Consultation consultation;

	
	
	


	
	public Rdv() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Rdv(Long id, LocalDate date, String adresse,Medecin medecin, Patient patient, Consultation consultation) {
		this.id = id;
		this.date = date;
		this.adresse = adresse;
		this.medecin = medecin;
		this.patient = patient;
		this.consultation=consultation;
	}
	

	public Consultation getConsultation() {
		return consultation;
	}


	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Long getId() {
		return id;
	}
	public Medecin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	

}
