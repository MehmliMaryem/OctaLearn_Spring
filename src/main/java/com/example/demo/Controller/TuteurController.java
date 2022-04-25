package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.TuteurRepository;
import com.example.demo.Service.TuteurService;
 import com.example.demo.model.Tuteur;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/tuteur")

public class TuteurController {
	private TuteurService tuteurService;
	@Autowired

	private TuteurRepository tuteurRepository;

	@PostMapping("/add")
	public Tuteur createTuteur(@RequestBody Tuteur tuteur) {
		return tuteurRepository.save(tuteur);
	}

	@GetMapping("/list")
	public List<Tuteur> getAllApprenants() {
		return (List<Tuteur>) tuteurRepository.findAll();
	}

	
	@GetMapping("/{Id}")
	public Tuteur getApprenant(@PathVariable Long Id) {
		Optional<Tuteur> t = tuteurRepository.findById(Id);
		return t.get();
	} 
	
	 @PutMapping("/{id}")
	public Tuteur updateTuteur(@PathVariable Long id, @Valid @RequestBody Tuteur tuteurRequest) {
		return tuteurRepository.findById(id).map(tuteur -> {
			tuteur.setName(tuteurRequest.getName());
			tuteur.setEmail(tuteurRequest.getEmail());
			tuteur.setMdp(tuteurRequest.getMdp());
			tuteur.setSpecialite(tuteurRequest.getSpecialite());
			return tuteurRepository.save(tuteur);
		}).orElseThrow(() -> new IllegalArgumentException("Id " + id + " not found"));
	} 

 @DeleteMapping("/{id}")
 public ResponseEntity<?> deleteTuteur(@PathVariable Long id) {
		return tuteurRepository.findById(id).map(tuteur -> {
			tuteurRepository.delete(tuteur);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new IllegalArgumentException("TuteurId " + id + " not found"));
	}

 
}
