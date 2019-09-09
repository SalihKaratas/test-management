package com.example.securudemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, name = "user_name")
	private String username;

	@Column(nullable = false, name = "password")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Column(name = "roles", nullable = false)
	private List<Role> roles;
	
	@ManyToMany
	@Column(name = "projects")
	private List<Project> projects;
	
	@ManyToMany
	@Column(name = "userGroups")
	private List<UserGroup> userGroups;
	
	private int active;
	
	public User(String username, String password) {
		
		this.username=username;
		this.password=password;	
		this.active = 1;
	}
	
}
