package com.example.securudemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Long>{

	Step findByStepName(String stepName);
	
}