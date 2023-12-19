package com.api.entity;

import jakarta.persistence.*;
import java.util.*;
import com.api.entity.*;

@Entity
@Table(name = "Matiere")

public class Matiere {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String nom;
	
	@Column 
	private String code;
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	private double note;
	 @ManyToMany(mappedBy = "matieres")
	    private Collection<Etudiant> etudiants = new ArrayList<>();

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}


	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getNote() {
		return note;
	}


	public void setNote(double note) {
		this.note = note;
	}

}
