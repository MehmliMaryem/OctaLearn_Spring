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
import com.example.demo.model.Chapitre;
import com.example.demo.model.Cours;
import com.example.demo.Repository.DocumentRepository;
import com.example.demo.Repository.ChapitreRepository;
import com.example.demo.Repository.CoursRepository;


@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/chapitre")
public class ChapitreController {
	
	@Autowired
	private DocumentRepository DocumentRepository;
	@Autowired
	private ChapitreRepository ChapitreRepository;
	@Autowired
	private CoursRepository CoursRepository;

	@PostMapping("/add/{id}/{idCours}")
	public Chapitre AddChapitre(@PathVariable(value = "id") Long id,@PathVariable(value = "idCours") Long idCours, @Valid @RequestBody Chapitre chap) {
		return DocumentRepository.findById(id).map(doc -> {
		chap.setDocument(doc);
		return CoursRepository.findById(idCours).map(cours -> {
			chap.setCours(cours);
			return ChapitreRepository.save(chap);
		}).orElseThrow(() -> new IllegalArgumentException("CoursId " + idCours + " not found"));
		}).orElseThrow(() -> new IllegalArgumentException("documentId " + id + " not found"));

	}
	@GetMapping("/list/{id}")
	 public List<Chapitre> getAllChapitre(@PathVariable(value = "id") long id) {
		Optional<Cours> co = CoursRepository.findById(id);
	 return (List<Chapitre>) ChapitreRepository.findByCours(co);
	 }

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCours(@PathVariable(value = "id") Long id) {
		return ChapitreRepository.findById(id).map(chap -> {
			ChapitreRepository.delete(chap);
			DocumentRepository.delete(chap.getDocument());
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new IllegalArgumentException("Chapitre not found with id " + id));
	}

}
