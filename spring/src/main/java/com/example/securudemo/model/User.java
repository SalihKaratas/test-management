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
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, name = "userName")
	private String username;

	@Column(nullable = false, name = "password")
	private String password;
	
	private int active;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Column(name = "roles", nullable = false)
	private List<Role> roles;
	
	
	public User(String username, String password) {
		
		this.username=username;
		this.password=password;	
		this.active = 1;
	}
	
}
