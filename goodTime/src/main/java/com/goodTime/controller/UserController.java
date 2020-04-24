package com.goodTime.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodTime.model.User;
import com.goodTime.serviceImplementation.UserServiceImpl;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/")
	public ResponseEntity<Object> registerNewClient(@RequestBody @Valid User user) {
		userService.registerUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity <List<User>> getUsers(){
		List<User> allUsers = userService.findAllUsers();
		return new ResponseEntity <List<User>> (allUsers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <User> getUser(@PathVariable("id") UUID id){
		return new ResponseEntity <User> (userService.findUserById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Object> deleteUser(@PathVariable("id") UUID id){
		userService.deleteUserById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
