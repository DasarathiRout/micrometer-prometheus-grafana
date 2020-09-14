package org.drout.spring.web.config;

import org.drout.spring.service.UserDetailsServiceJWT;
import org.drout.spring.web.filter.RequestFilterJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurationJWT extends WebSecurityConfigurerAdapter {

	// ==============================================================================================
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		PasswordEncoder rawTextNoEncoding = NoOpPasswordEncoder.getInstance();
		return rawTextNoEncoding;
	}

	// ==============================================================================================
	@Autowired
	private UserDetailsServiceJWT userDetailsService;

	@Override
	public void configure(AuthenticationManagerBuilder authManager) throws Exception {
		authManager.userDetailsService(userDetailsService);
	}

	// ==============================================================================================
	@Autowired
	private RequestFilterJWT requestFilterJWT;

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
				.antMatchers("/api/v1/actuator", "/api/v1/home/index", "/api/v1/authenticate").permitAll()
				// .anyRequest().authenticated()
				.and().exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(requestFilterJWT, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		// webSecurity.ignoring().antMatchers("/api/v1/actuator", "/api/v1/home/index",
		// "/api/v1/authenticate");
	}

	// ==============================================================================================
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
