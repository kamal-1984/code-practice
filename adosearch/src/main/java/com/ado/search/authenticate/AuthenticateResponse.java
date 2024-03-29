/*
 * 
 */
package com.ado.search.authenticate;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthenticationResponse.
 */
public class AuthenticateResponse {
	
	/** The jwt. */
	private final String jwt;
	
	/**
	 * Instantiates a new authentication response.
	 *
	 * @param jwt the jwt
	 */
	public AuthenticateResponse(String jwt) {
		this.jwt = jwt;
	}

	/**
	 * Gets the jwt.
	 *
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}
	
}
