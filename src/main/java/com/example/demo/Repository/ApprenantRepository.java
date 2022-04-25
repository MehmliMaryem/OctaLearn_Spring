package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Apprenant;
@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {

}
