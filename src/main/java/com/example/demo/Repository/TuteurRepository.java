package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tuteur;

public interface TuteurRepository extends JpaRepository<Tuteur, Long> {

}
