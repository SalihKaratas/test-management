package com.example.securudemo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "projectName", nullable = false)
	private String projectName;
	
	//auto-fill
	@Column(name = "createdBy", nullable = false)
	private User createdBy;
	
	@Column(name = "exStartDate")
	private Date exStartDate;
	
	@Column(name = "startDate", nullable = false)
	private Date startDate;
	
	@Column(name = "exEndDate", nullable = false)
	private Date exEndDate;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@ManyToMany
	@Column(name = "requirements")
	private List<Requirement> requirements;
	
	@OneToMany
	@Column(name = "mileStones")
	private List<MileStone> mileStones;
	
	@ManyToMany
	@Column(name = "accessibleUsers")
	private List<User> accessibleUsers;
	
	@ManyToMany
	@Column(name = "accessibleUserGroups")
	private List<UserGroup> accessibleUserGroups;
	
}
