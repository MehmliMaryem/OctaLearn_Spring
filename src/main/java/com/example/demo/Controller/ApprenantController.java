package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ApprenantRepository;
import com.example.demo.Service.ApprenantService;
import com.example.demo.model.Apprenant;
import com.example.demo.model.Tuteur;

@RestController
@RequestMapping(path = "/apprenant")
public class ApprenantController {
 private ApprenantService apprenantService;
@Autowired
private ApprenantRepository apprenantRepository;
@PostMapping("/add")
public Apprenant createApprenat(@RequestBody Apprenant apprenant) {
	return apprenantRepository.save(apprenant);
}



@GetMapping("/list")
public List<Apprenant> getAllApprenants() {
	return (List<Apprenant>) apprenantRepository.findAll();
}


@GetMapping("/{Id}")
public Apprenant getApprenant(@PathVariable Long Id) {
	Optional<Apprenant> a = apprenantRepository.findById(Id);
	return a.get();
} 


}
