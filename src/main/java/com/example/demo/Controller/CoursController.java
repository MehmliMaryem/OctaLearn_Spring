package com.example.demo.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.CoursRepository;
import com.example.demo.Repository.TuteurRepository;
import com.example.demo.Service.CoursService;
import com.example.demo.model.Cours;
import com.example.demo.model.Tuteur;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/cours")
public class CoursController {
	private CoursService coursService;
	@Autowired
	private CoursRepository coursRepository;
	@Autowired
	private TuteurRepository tuteurRepository;

	@PostMapping("/add/{id}")
	public Cours AddCours(@PathVariable(value = "id") Long id, @Valid @RequestBody Cours cours) {
		return tuteurRepository.findById(id).map(tuteur -> {
			cours.setTuteur(tuteur);
			return coursRepository.save(cours);
		}).orElseThrow(() -> new IllegalArgumentException("TuteurId " + id + " not found"));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCours(@PathVariable(value = "id") Long id) {
		return coursRepository.findById(id).map(cours -> {
			coursRepository.delete(cours);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new IllegalArgumentException("cours not found with id " + id));
	}

	 @GetMapping("/list")
	 public List<Cours> getAllCours() {
	 return (List<Cours>) coursRepository.findAll();
	 }
	 
	 @GetMapping("/listC/{id}")
	 public List<Cours> getCours(@PathVariable(value = "id") long id) {
		 Optional<Tuteur> tut = tuteurRepository.findById(id);
	 return (List<Cours>) coursRepository.findByTuteur(tut);
	 }
}
