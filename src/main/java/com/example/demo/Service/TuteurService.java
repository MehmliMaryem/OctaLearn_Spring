package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Apprenant;
import com.example.demo.model.Tuteur;
 
public interface TuteurService {
	Tuteur save(Tuteur tuteur);
	 ArrayList<Tuteur> getAllTuteurs() ;
//	ObjectResponse exists(Tuteur t);

//	 Service save(Service service);

		Tuteur findById(String id);
	//	ObjectResponse AddApprenantToTuteur(Tuteur tuteur, Apprenant apprenant);
 		Tuteur findByUsername(String nomComplet);
	 List<Apprenant> VoirApprenantTuteur(String Currentuser, String tuteurid);
  }
