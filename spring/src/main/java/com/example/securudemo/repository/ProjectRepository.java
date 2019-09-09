package com.example.securudemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	Project findByProjectName(String projectName);
	
}