package com.college.library.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.college.library.domain.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomUserDetails implements UserDetails {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	//To get the roles of the user and grant the authority
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//return user.getRole().stream().map(role-> new SimpleGrantedAuthority("ROLE"+role)).collect(Collectors.toList());
		return user.getRole().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role))
				.collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	



}
