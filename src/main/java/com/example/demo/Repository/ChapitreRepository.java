package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Chapitre;
import com.example.demo.model.Cours;

@Repository
public interface ChapitreRepository extends JpaRepository<Chapitre, Long> {
	ArrayList<Chapitre> findByCours(Optional<Cours> co);
}
