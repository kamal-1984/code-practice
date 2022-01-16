/*
 * 
 */
package com.freenow.security.service;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtTokenUtil.
 */
@Service
public class JwtTokenUtil {
	
	/** The Constant SECRET_KEY. */
	private static final String SECRET_KEY = "freenow_secret_key";
	
	/**
	 * Generate token.
	 *
	 * @param userDetails the user details
	 * @return the string
	 */
	public String generateToken(UserDetails userDetails) {
		final Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
        claims.put("iss", "freenow");
        claims.put("username", userDetails.getUsername());
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
        		.setExpiration(new Date(System.currentTimeMillis() +1000 * 60 * 60 * 1))
        		.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	/**
	 * Extract username.
	 *
	 * @param token the jwt
	 * @return the string
	 */
	public String extractUsername(String token) {
		return this.extractClaim(token, Claims::getSubject);
	}

	/**
	 * Extract claim.
	 *
	 * @param <T> the generic type
	 * @param token the jwt
	 * @param claimsResolver the claims resolver
	 * @return the string
	 */
	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		return claimsResolver.apply(claims);
	}

	/**
	 * Validate token.
	 *
	 * @param token the jwt
	 * @param userDetails the user details
	 * @return true, if successful
	 */
	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = this.extractUsername(token);
		return (username.equals(userDetails.getUsername()) && this.isTokenValid(token));
	}

	/**
	 * Checks if is token valid.
	 *
	 * @param token the token
	 * @return true, if is token valid
	 */
	private boolean isTokenValid(String token) {
		return extractExpiration(token).after(new Date());
	}
	
	/**
	 * Extract expiration.
	 *
	 * @param token the token
	 * @return the date
	 */
	public Date extractExpiration(String token) {
		return this.extractClaim(token, Claims::getExpiration);
	}

}
