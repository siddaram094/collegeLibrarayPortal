package com.college.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.library.domain.User;
import com.college.library.repositories.UserRepository;

@Service
public class AdminService {

	@Autowired
	UserRepository userRepository;
	public String addUsers(User user) {
		userRepository.save(user);
		return "User saved successfully";
	}
}
