package com.example.securudemo.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.Role;
import com.example.securudemo.model.User;

@Service
public class DbInit implements CommandLineRunner{

	private UserRepository userRepository;
	
	private RoleRepository roleRepository;
	
	private PasswordEncoder passwordEncoder;
	
	public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.roleRepository=roleRepository;
	}
	
	@Override
	public void run(String... args) {
		userRepository.deleteAll();
		roleRepository.deleteAll();
		
		//Create 1st Role and User
		//Create Role with RoleName and Permission
		Role roleAdmin = new Role("ADMIN","ACCESS_TEST1");
		
		//Create User with UserName and Password and Roles
		User salih = new User("salih", passwordEncoder.encode("salih"));
		
		//Roles add to user
		salih.setRoles(Arrays.asList(roleAdmin));
		
		//Create 2nd Role and User
		Role roleUser = new Role("USER","");	
		User irsat = new User("irsat", passwordEncoder.encode("irsat"));
		irsat.setRoles(Arrays.asList(roleUser,roleAdmin));
		
		
		//Created roles added to the "roles" list
		List<Role> roles = Arrays.asList(roleAdmin,roleUser);
		
		//Created users added to the "users" list
		List<User> users =Arrays.asList(salih,irsat);
		
		//saving to DB reis
		this.roleRepository.saveAll(roles);
		this.userRepository.saveAll(users);
	}
}
