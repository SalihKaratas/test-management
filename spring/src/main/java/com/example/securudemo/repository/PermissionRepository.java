package com.example.securudemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securudemo.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{
	Permission findByPermissionName(String permissionName);

}
