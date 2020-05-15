package com.goodTime.demainobject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.rest.core.config.Projection;

import com.goodTime.model.Movie;
import com.goodTime.model.User;

@Projection(name="userDetails", types= {User.class})
public interface UserResponseObject {
	
	UUID getId();
	String getName();
	String getEmailAddress();
	String getPhoneNumber();
	String getAddress();
	boolean isActivated();
	boolean isAdmin();
	boolean isBusinessOwner();
	LocalDateTime getLastLogIn();
	LocalDateTime getJoinedAt();
	List<Movie> getMovies();
}
