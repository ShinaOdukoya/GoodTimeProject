package com.goodTime.serviceImplementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.goodTime.exception.BadRequestException;
import com.goodTime.exception.NotFoundException;
import com.goodTime.model.Role;
import com.goodTime.model.User;
import com.goodTime.repository.RoleRepository;
import com.goodTime.repository.UserRepository;
import com.goodTime.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	// Registers new users
	@Override
	public void registerUser(User user) {
		if(userRepository.findByEmailAddress(user.getEmailAddress()) != null)
			throw new BadRequestException("User email "+user.getEmailAddress()+" already exist!");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleRepository.findRoleByName("ROLE_USER");
		user.setRoles(Arrays.asList(role));		
		userRepository.save(user);
	}
	
	// Returns list of all users
	@Override
	public List<User> findAllUsers() {
		if(userRepository.findAll().isEmpty())
			throw new NotFoundException("User table is empty!");
		return userRepository.findAll();
	}
	
	// Returns an existing client by its email address
	@Override
	public User findUserByEmailAddress(String emailAddress) {
		if(userRepository.findByEmailAddress(emailAddress) == null)
			throw new NotFoundException("User email "+emailAddress+" not found!");
		return userRepository.findByEmailAddress(emailAddress).get();
	}
		
	// Returns an existing user by its ID
	@Override
	public User findUserById(long id) {
		return userRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException("User with ID " + id + " not found!"));
	}
		
	//Deletes an existing user by its ID
	@Override
	public void deleteUserById(long id) {
		if(userRepository.findById(id).isEmpty())
			throw new NotFoundException("User with ID "+id+" does not exist!");
		userRepository.deleteById(id);
	}
	
	//Updates an existing user
	@Override
	public User updateUser(long id, User user) {
		return userRepository.saveAndFlush(user);
	}
	
	@Override
	public void sendConfirmationMail(User user) {
		
	}

	@Override
	public User findUserByEmailAddressOrUserName(String usernameOrEmail) {
		return userRepository.findByUsername(usernameOrEmail);
	}
}
