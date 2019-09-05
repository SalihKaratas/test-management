package com.example.securudemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.User;
import com.example.securudemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Secured("ROLE_ADMIN")
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
		
	}
	@Secured("ROLE_USER")
	@Override
	public void irsat() {
		System.out.println("naaber");
	}

}
