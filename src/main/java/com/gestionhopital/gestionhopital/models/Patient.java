package com.gestionhopital.gestionhopital.models;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class Patient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@Column(name="nom")
	private String nom;
	@Column(name="numSecu")
	private Long numSecu;
	
	
	@OneToMany(mappedBy =  "patient", fetch = FetchType.LAZY)
	private Collection<Rdv> rdv;
	
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Patient(String nom, Long numSecu) {
	
		this.nom = nom;
		this.numSecu = numSecu;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getNumSecu() {
		return numSecu;
	}
	public void setNumSecu(Long numSecu) {
		this.numSecu = numSecu;
	}
	
	@JsonIgnore
	public Collection<Rdv> getRdvs() {
		return rdv;
	}
	

}
