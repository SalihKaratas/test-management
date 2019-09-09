package com.example.securudemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class TestCase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "testCaseName", nullable = false)
	private String testCaseName;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "description ",  nullable = false)
	private String description;
	
	@ManyToOne
	@Column(name = "requirements", nullable = false)
	private List<Requirement> requirements;
	
	@OneToMany
	@Column(name = "steps", nullable = false)
	private List<Step> steps;
	
	
}
