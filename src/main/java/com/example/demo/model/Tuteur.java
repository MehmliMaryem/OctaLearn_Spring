package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tuteur")
public class Tuteur  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

   private long id;
	@Column(name="name")
   private String Name;
   @Column (name="email")
   private String email;
   @Column (name="mdp")
   private String mdp;
 	@Column(name="specialite")
	private String specialite;
 	
 	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Tuteur(long id, String name, String email, String specialite) {
		super();
		this.id = id;
		Name = name;
		this.email = email;
		this.specialite = specialite;
	}
	public Tuteur() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	 
	
 

}
