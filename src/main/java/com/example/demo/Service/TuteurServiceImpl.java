package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

 import com.example.demo.Repository.TuteurRepository;
import com.example.demo.model.Apprenant;
import com.example.demo.model.Tuteur;

@Service
public class TuteurServiceImpl {
	private TuteurRepository tuteurRepository;

	public Tuteur save(Tuteur tuteur) {
		return tuteurRepository.save(tuteur);
	}

	public List<Tuteur> getAllTuteur() {
		return tuteurRepository.findAll();
	}
	
	
	 
}
