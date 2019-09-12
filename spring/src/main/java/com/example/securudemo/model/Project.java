package com.example.securudemo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "project_name", nullable = false)
	private String projectName;
	
	
	@Column(name = "ex_start_date")
	private Date exStartDate;
	
	@Column(name = "create_date", nullable = false)
	private Date createDate;
	
	@Column(name = "ex_end_date", nullable = false)
	private Date exEndDate;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "project_requirements",
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "requirement_id"))
	private List<Requirement> requirements;
	
	@OneToMany
	private List<MileStone> mileStones;
	
	@ManyToMany(mappedBy = "accessibleProjects")
	private List<User> accessibleUsers;
	
	@ManyToMany(mappedBy = "accessibleProjects")
	private List<Group> accessibleUserGroups;

	public Project(String projectName, Date exStartDate, Date exEndDate, String status,
			User createdBy) {
		super();
		this.projectName = projectName;
		this.exStartDate = exStartDate;
		this.createDate = new Date(System.currentTimeMillis());
		this.exEndDate = exEndDate;
		this.status = status;
		this.createdBy = createdBy;
	}
	
	
	
	
	
	
}
