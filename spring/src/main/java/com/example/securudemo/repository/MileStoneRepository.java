package com.example.securudemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securudemo.model.MileStone;

@Repository
public interface MileStoneRepository extends JpaRepository<MileStone, Long>{

	MileStone findByMileStoneName(String mileStoneName);
	
}