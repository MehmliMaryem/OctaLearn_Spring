package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chapitre")
public class Chapitre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "num")
	private int numChapitre;
 
	@Column(name = "nom")
	private String nomChapitre;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	 @JoinColumn(name = "document", nullable = false)
	private Document document;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	 @JoinColumn(name = "cours", nullable = false)
	private Cours cours;

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumChapitre() {
		return numChapitre;
	}

	public void setNumChapitre(int numChapitre) {
		this.numChapitre = numChapitre;
	}

	public String getNomChapitre() {
		return nomChapitre;
	}

	public void setNomChapitre(String nomChapitre) {
		this.nomChapitre = nomChapitre;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	
	
	

	 
	
	
	
	
}
