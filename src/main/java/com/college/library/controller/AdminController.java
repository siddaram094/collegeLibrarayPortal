package com.college.library.controller;

import org.aspectj.weaver.ast.HasAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.library.domain.User;
import com.college.library.repositories.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAnyRole('ADMIN')") 
	@PostMapping("/addUsers")
	public ResponseEntity<Object> addUsers(@RequestBody User user){
		user.setPassword(passwordEncoder.encode(user.getPassword())); 
		userRepository.save(user);
		return new ResponseEntity<Object>("", HttpStatus.OK);
	}
}
