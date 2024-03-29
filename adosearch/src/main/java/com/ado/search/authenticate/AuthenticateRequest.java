/*
 * 
 */
package com.ado.search.authenticate;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthenticateRequest.
 */
public class AuthenticateRequest {
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/**
	 * Instantiates a new authenticate request.
	 */
	public AuthenticateRequest() {
		
	}
	
	/**
	 * Instantiates a new authenticate request.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public AuthenticateRequest(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
