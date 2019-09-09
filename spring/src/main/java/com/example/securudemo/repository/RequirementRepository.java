package com.example.securudemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.Requirement;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Long>{

	Requirement findByRequirementName(String requirementName);
	
}