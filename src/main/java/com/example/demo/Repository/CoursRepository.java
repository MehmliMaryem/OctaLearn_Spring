package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cours;
import com.example.demo.model.Tuteur;

public interface CoursRepository extends JpaRepository<Cours, Long> {
	ArrayList<Cours> findByTuteur(Optional<Tuteur> tut);
}
