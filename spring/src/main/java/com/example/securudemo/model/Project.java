package com.example.securudemo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "projectName", nullable = false)
	private String projectName;
	
	
	@Column(name = "exStartDate")
	private Date exStartDate;
	
	@Column(name = "createDate", nullable = false)
	private Date createDate;
	
	@Column(name = "exEndDate", nullable = false)
	private Date exEndDate;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne
	@JoinColumn(name = "createdBy")
	private User createdBy;
	
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
