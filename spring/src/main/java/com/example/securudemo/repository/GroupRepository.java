package com.example.securudemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.Group;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{

	Group findByGroupName(String groupName);
	
}