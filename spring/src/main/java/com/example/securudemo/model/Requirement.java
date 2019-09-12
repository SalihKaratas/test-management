package com.example.securudemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "requirements")
public class Requirement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "requirement_name", nullable = false)
	private String requirementName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "requirements")
	private List<Project> projects;
	
	@OneToMany
	private List<TestCase> testCases;

	public Requirement(String requirementName) {
		super();
		this.requirementName = requirementName;
		
	}
	
	
	
}
