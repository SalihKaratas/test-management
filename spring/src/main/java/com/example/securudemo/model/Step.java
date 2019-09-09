package com.example.securudemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Step {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "stepName", nullable = false)
	private String stepName;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "preCOndition", nullable = false)
	private String preCondition;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "exResult", nullable = false)
	private String exResult;

	@ManyToOne
	@Column(name = "testCases", nullable = false)
	private List<TestCase> testCases;
	
}
