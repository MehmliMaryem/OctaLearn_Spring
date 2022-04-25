package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="apprenant")
public class Apprenant extends User {
	@Column(name="niveau")
	private Niveau niveau;

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Apprenant(long id, String name, String email, Niveau niveau) {
		super(id, name, email);
		this.niveau = niveau;
	}

	public Apprenant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apprenant(long id, String name, String email) {
		super(id, name, email);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
