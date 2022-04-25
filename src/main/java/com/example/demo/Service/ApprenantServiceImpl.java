package com.example.demo.Service;

import java.util.List;

import com.example.demo.Repository.ApprenantRepository;
import com.example.demo.model.Apprenant;
import com.example.demo.model.Tuteur;

public class ApprenantServiceImpl {
private ApprenantRepository apprenantRepository;

public Apprenant save(Apprenant apprenant) {
	return apprenantRepository.save(apprenant);
}

public List<Apprenant> getAllApprenant() {
	return apprenantRepository.findAll();
}
}
