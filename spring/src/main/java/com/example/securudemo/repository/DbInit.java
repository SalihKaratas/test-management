package com.example.securudemo.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.Permission;
import com.example.securudemo.model.Project;
import com.example.securudemo.model.Requirement;
import com.example.securudemo.model.Role;
import com.example.securudemo.model.User;

@Service
public class DbInit implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private RequirementRepository requirementRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws ParseException {
		userRepository.deleteAll();
		roleRepository.deleteAll();
		permissionRepository.deleteAll();
		projectRepository.deleteAll();
		requirementRepository.deleteAll();
		//Create 1st Role and User
		//Create Role with RoleName and Permission		
		Permission perm1 = new Permission("ACCESS_TEST1");
		Permission perm2 = new Permission("ACCESS_TEST2");		
		Role roleAdmin = new Role("ADMIN",Arrays.asList(perm1,perm2));		
		//Create User with UserName and Password and Roles
		User salih = new User("salih", passwordEncoder.encode("salih"));		
		//Roles add to user
		salih.setRoles(Arrays.asList(roleAdmin));		
		//Create 2nd Role and User
		Role roleUser = new Role("USER",Arrays.asList(perm1));	
		User irsat = new User("irsat", passwordEncoder.encode("irsat"));
		irsat.setRoles(Arrays.asList(roleUser,roleAdmin));		
		//Created roles added to the "roles" list
		List<Role> roles = Arrays.asList(roleAdmin,roleUser);		
		List<Permission> perms = Arrays.asList(perm1,perm2);
		//Created users added to the "users" list
		List<User> users =Arrays.asList(salih,irsat);		
		//saving to DB reis
		this.permissionRepository.saveAll(perms);
		this.roleRepository.saveAll(roles);
		this.userRepository.saveAll(users);
		
		//--------------------proje oluştur-------------------------//
		
		Date exStart = new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-01");
		Date exEnd = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-31");
		
		Project pro1 = new Project("ProjectX", exStart, exEnd, "waiting", userRepository.findByUsername("salih"));
		Project pro2 = new Project("Projecty", exStart, exEnd, "flush", userRepository.findByUsername("irsat"));
		pro1.setDescription("project x description");
		pro2.setDescription("flushed");
		projectRepository.saveAll(Arrays.asList(pro1,pro2));
		System.out.println(projectRepository.findByProjectName("ProjectX").getStatus());
		System.out.println(projectRepository.findByProjectName("ProjectX").getDescription());
		
		//------------------requirement oluştur------------------//
		
		Requirement req1 = new Requirement("req1");
		requirementRepository.save(req1);
		pro1.setRequirements(Arrays.asList(req1));
		
		
		
	}
}
