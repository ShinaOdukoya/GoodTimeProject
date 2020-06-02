package com.goodTime.service;

import java.util.List;

import com.goodTime.model.User;

public interface UserService {
	
	void registerUser(User user);
	void sendConfirmationMail(User user);
	void deleteUserById(long id);
	User updateUser(long id, User user);
	User findUserByEmailAddress(String emailAddress);
	User findUserById(long id);
	User findUserByEmailAddressOrUserName(String usernameOrEmail);
	List<User> findAllUsers();
}
