package org.drout.spring.web;

import org.drout.spring.service.UserDetailsServiceJWT;
import org.drout.spring.web.jwt.UtilityJWT;
import org.drout.spring.web.model.AuthenticateRequest;
import org.drout.spring.web.model.AuthenticateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceAuthenticate {
	private static final Logger log = LoggerFactory.getLogger(ResourceAuthenticate.class);

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceJWT userDetailsServiceJWT;
	@Autowired
	private UtilityJWT jwtUtility;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticateTokens(@RequestBody AuthenticateRequest authenticateRequest)
			throws Exception {
		log.error("/api/v1/authenticate");

		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					authenticateRequest.getUserName(), authenticateRequest.getPassKey());
			authenticationManager.authenticate(authenticationToken);
		} catch (Exception e) {
			throw new Exception(
					"Sorry, Incorrect Username & Password Combination : " + e);
		} finally {

		}
		final UserDetails userDetails = userDetailsServiceJWT.loadUserByUsername(authenticateRequest.getUserName());
		final String jwtToken = jwtUtility.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticateResponse(jwtToken));
	}

}
