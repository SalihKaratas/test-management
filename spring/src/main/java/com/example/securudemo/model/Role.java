package com.example.securudemo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(nullable = false)
	private String permission;
	
	@ManyToMany
	@Column(name = "users")
	private List<User> users;
	
	public Role(String roleName, String permission) {
		
		this.roleName = roleName;
		this.permission = permission;
		
	}
	
	public List<String> getPermissionList(){
		if(this.permission.length()>0) {
			return Arrays.asList(this.permission.split(","));
		}
		return new ArrayList<>();
	}

	public List<String> getRoleList(){
		if(this.roleName.length() > 0){
			return Arrays.asList(this.roleName.split(","));
		}
		return new ArrayList<>();
	}
	
}
