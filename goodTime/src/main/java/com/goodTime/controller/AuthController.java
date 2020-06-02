package com.goodTime.controller;

import com.goodTime.exception.BadRequestException;
import com.goodTime.model.AuthProvider;
import com.goodTime.model.Role;
import com.goodTime.model.User;
import com.goodTime.payload.AuthResponse;
import com.goodTime.payload.LoginRequest;
import com.goodTime.payload.SignUpRequest;
import com.goodTime.repository.RoleRepository;
import com.goodTime.repository.UserRepository;
import com.goodTime.securityconfiguration.TokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Arrays;

@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private RoleRepository roleRepository;

	@PostMapping("/auth/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = tokenProvider.createToken(authentication);
		return ResponseEntity.ok(new AuthResponse(token));
	}

	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByEmailAddress(signUpRequest.getEmail())) {
			throw new BadRequestException("Email address already in use.");
		}

		// Creating user's account
		User user = new User();
		user.setName(signUpRequest.getName());
		user.setEmailAddress(signUpRequest.getEmail());
		user.setUserName(signUpRequest.getUsername());
		user.setPassword(signUpRequest.getPassword());
		user.setProvider(AuthProvider.local);
		Role role = roleRepository.findRoleByName("ROLE_USER");
		user.setRoles(Arrays.asList(role));

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userRepository.save(user);

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

}
