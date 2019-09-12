package com.example.securudemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "test_cases")
public class TestCase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "test_case_name", nullable = false)
	private String testCaseName;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "description ",  nullable = false)
	private String description;
	
	@ManyToOne
	private Requirement requirements;
	
	@OneToMany
	private List<Step> steps;
	
	
}
