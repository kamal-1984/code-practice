/*
 * 
 */
package com.ado.search.security.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdayUserDetailsService.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new User("admin","admin", new ArrayList<>());
	}

}
