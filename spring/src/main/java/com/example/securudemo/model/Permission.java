package com.example.securudemo.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Permission {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "permission_name")
	private String permissionName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "permissions")
	private List<Role> roles;

	public Permission(String permissionName) {
		super();
		this.permissionName = permissionName;
	}
	
	
	
	

}
