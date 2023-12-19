package com.api.entity;

import jakarta.persistence.*;


@Entity
public class Note {

	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String nom;
	
	@Column
	private double note;
}
