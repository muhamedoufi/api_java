package com.api.entity;

import jakarta.persistence.*;

import java.util.*;

import com.api.entity.*;

@Entity
@Table(name = "Etudiant")

public class Etudiant {

	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String nom;
	
	
	@Column(unique = true)
	private String matricule;
	
//	@Enumerated(EnumType.STRING)
//	@Enumerated(EnumType.ORDINAL)
	@Column
	private Filiere filiere;
	

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="Etudiant_Matiere",joinColumns = {
			@JoinColumn(name="etudiant_id")
	},
	inverseJoinColumns = {@JoinColumn(name="matiere_id")})
	
	private Collection<Matiere> matieres = new ArrayList<>();
	
	public Collection<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Collection<Matiere> matieres) {
		this.matieres = matieres;
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Filiere getFiliere() {
//		return filiere.name();
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	
}
