package com.example.securudemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long>{

	UserGroup findByUserGroupName(String userGroupName);
	
}