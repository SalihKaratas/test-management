package com.example.securudemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Requirement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "requirementName", nullable = false)
	private String requirementName;
	
	@ManyToMany
	@Column(name = "projects", nullable = false)
	private List<Project> projects;
	
	@OneToMany
	private List<TestCase> testCases;
	
}
