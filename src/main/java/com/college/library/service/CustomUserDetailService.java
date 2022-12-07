package com.college.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.college.library.domain.User;
import com.college.library.repositories.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepositories;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepositories.findByUserName(username).get(); 
		System.out.println(user);
		CustomUserDetails userDetails = null;
		if(user!=null) {
			userDetails=new CustomUserDetails(user);
		}else {
			throw new UsernameNotFoundException("Uset not foud with name "+ username);
		}
		return userDetails;
	}

}
