/*
 * 
 */
package com.freenow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freenow.authenticate.AuthenticateRequest;
import com.freenow.authenticate.AuthenticateResponse;
import com.freenow.security.service.FreeNowUserDetailsService;
import com.freenow.security.service.JwtTokenUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthenticateController.
 */
@RestController
public class AuthenticateController {
	
	/** The authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/** The Free now user details service. */
	@Autowired
	private FreeNowUserDetailsService freeNowUserDetailsService;
	
	/** The jwt token util. */
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	/**
	 * Authenticate.
	 *
	 * @param authenticateRequest the authenticate request
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest authenticateRequest) throws Exception{
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword()));
		}catch(BadCredentialsException e) {
			throw new Exception(" Invalid username and password ",e);
		}
		
		final UserDetails userDetails = this.freeNowUserDetailsService
				.loadUserByUsername(authenticateRequest.getUsername());
		
		final String jwt = this.jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticateResponse(jwt));
	}

}
