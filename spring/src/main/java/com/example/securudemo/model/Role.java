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
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String roleName;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Column(name = "permissions", nullable = false)
	private List<Permission> permissions;
	
	@ManyToMany
	@Column(name = "users")
	private List<User> users;
	
	public Role(String roleName, List<Permission> permission) {
		
		this.roleName = roleName;
		this.permissions = permission;
		
	}
	
	
}
