package com.goodTime.securityconfiguration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.goodTime.AuthenticationFilter;
import com.goodTime.LoginFilter;
import com.goodTime.serviceImplementation.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().cors().and().authorizeRequests().anyRequest().permitAll()
		.and()// Filter for the api/login requests
		.addFilterBefore(new LoginFilter("/login", authenticationManager()),
				UsernamePasswordAuthenticationFilter.class)
		// Filter for other requests to check JWT in header
		.addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
		.csrf().disable();
	}
	
	
	
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("*"));
		config.setAllowedMethods(Arrays.asList("*"));
		config.setAllowedHeaders(Arrays.asList("*"));
		config.setAllowCredentials(true);
		config.applyPermitDefaultValues();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

}
