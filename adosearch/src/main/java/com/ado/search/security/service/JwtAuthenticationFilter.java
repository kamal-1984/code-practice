/*
 * 
 */
package com.ado.search.security.service;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtAuthenticationFilter.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	/** The user details service. */
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	/** The jwt token util. */
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/**
	 * Do filter internal.
	 *
	 * @param request the request
	 * @param response the response
	 * @param filterChain the filter chain
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			final String authorizationHeader = request.getHeader("Authorization");
			
			String username = null;
			String jwt = null;
			if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
				jwt = authorizationHeader.substring(7);
				username = this.jwtTokenUtil.extractUsername(jwt);
			}
			
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
				if(this.jwtTokenUtil.validateToken(jwt,userDetails)) {
					final UsernamePasswordAuthenticationToken usernamePwdAuthToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePwdAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePwdAuthToken);
				}
			}
			
			filterChain.doFilter(request, response);
	}

}
