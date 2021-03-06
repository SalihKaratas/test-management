package com.example.securudemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.TestCase;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long>{

	TestCase findByTestCaseName(String testCaseName);
	
}