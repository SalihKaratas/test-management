package com.example.securudemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;


@Data
@Entity
public class UserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "userGroupName", nullable = false)
	private String userGroupName; 
	
	@ManyToMany
	@Column(name = "projects")
	private List<Project> projects;
	
	@ManyToMany
	@Column(name = "users")
	private List<User> users;
	
	
	
}
