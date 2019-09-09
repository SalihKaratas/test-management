package com.example.securudemo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class MileStone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "mileStoneName", nullable = false)
	private String mileStoneName;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany
	@Column(name = "project", nullable = false)
	private List<Project> project;
}
