package org.drout.spring.service;

import java.util.ArrayList;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@EnableWebSecurity
public class UserDetailsServiceJWT implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		ArrayList<GrantedAuthority> authorities = new ArrayList<>(4);
		User userX = new User("dasarathi", "dasarathirout", authorities);
		return userX;
	}

}
