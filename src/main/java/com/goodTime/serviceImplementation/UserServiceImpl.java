package com.goodTime.serviceImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.goodTime.exception.BadRequestException;
import com.goodTime.exception.NotFoundException;
import com.goodTime.model.Movie;
import com.goodTime.model.User;
import com.goodTime.repository.MovieRepository;
import com.goodTime.model.Role;
import com.goodTime.repository.RoleRepository;
import com.goodTime.repository.UserRepository;
import com.goodTime.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieRepository movieRepository;

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	// Registers new users
	@Override
	public void registerUser(User user) {
		if(userRepository.findByEmailAddress(user.getEmailAddress()) != null)
			throw new BadRequestException("User email "+user.getEmailAddress()+" already exist!");
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleRepository.findById((long) 3).get();
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
		return userRepository.findByEmailAddress(emailAddress);
	}
		
	// Returns an existing user by its ID
	@Override
	public User findUserById(UUID id) {
		return userRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException("User with ID " + id + " not found!"));
	}
		
	//Deletes an existing user by its ID
	@Override
	public void deleteUserById(UUID id) {
		if(userRepository.findById(id).isEmpty())
			throw new NotFoundException("User with ID "+id+" does not exist!");
		userRepository.deleteById(id);
	}
	
	//Updates an existing user
	@Override
	public User updateUser(UUID id, User user) {
		user = findUserById(id);
		
		return userRepository.saveAndFlush(user);
	}
	
	@Override
	public void sendConfirmationMail(User user) {
		
	}
	
	@Override
	public User createMoviePlayList(UUID userId, Long id){
		
		User user = userRepository.getOne(userId);
		List<Movie> movieplaylist = new ArrayList<>();

			List<Movie> allMovies = movieRepository.findAll();
			
			for(Movie movie : allMovies) {
				movie = movieRepository.getOne(id);
				 if(movieplaylist.contains(movie)) {
					
					 user.getMovies();
				 }else {
					 movieplaylist.add(movie);
				 }
				 user.setMovies(movieplaylist);
				 userRepository.save(user);		
			}	 
		return userRepository.saveAndFlush(user);
		
	}

	@Override
	public User findUserByEmailAddressOrUserName(String usernameOrEmail) {
		return userRepository.findByUsername(usernameOrEmail);
	}
}
