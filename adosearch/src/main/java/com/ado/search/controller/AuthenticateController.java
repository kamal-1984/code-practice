/*
 * 
 */
package com.ado.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ado.search.authenticate.AuthenticateRequest;
import com.ado.search.authenticate.AuthenticateResponse;
import com.ado.search.security.service.CustomUserDetailsService;
import com.ado.search.security.service.JwtTokenUtil;

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
	private CustomUserDetailsService updayUserDetailsService;
	
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
		}catch(final BadCredentialsException e) {
			throw new Exception(" Invalid username and password ",e);
		}
		
		final UserDetails userDetails = this.updayUserDetailsService
				.loadUserByUsername(authenticateRequest.getUsername());
		
		final String jwt = this.jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticateResponse(jwt));
	}
	
	/**
	 * Upload file.
	 *
	 * @param file the file
	 * @return the response entity
	 */
	@PostMapping(value="/uploadFile")
	public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file ){
		System.out.println(file.getName());
		return null;
	}
	
	/**
	 * Say hello.
	 *
	 * @param name the name
	 * @return the string
	 */
	@PostMapping(value="/hello")
	public String sayHello(@RequestParam String name) {
		return "Hello "+name;
	}

}
