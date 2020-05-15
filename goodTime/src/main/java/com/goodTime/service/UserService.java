package com.goodTime.service;

import java.util.List;
import java.util.UUID;

import com.goodTime.model.User;

public interface UserService {
	
	void registerUser(User user);
	void sendConfirmationMail(User user);
	void deleteUserById(UUID id);
	User updateUser(UUID id, User user);
	User findUserByEmailAddress(String emailAddress);
	User findUserById(UUID id);
	List<User> findAllUsers();
	User createMoviePlayList(UUID user_id, Long id);
}
