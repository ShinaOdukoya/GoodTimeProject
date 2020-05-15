package com.goodTime.service;

import java.util.List;
import java.util.UUID;

import com.goodTime.model.Movie;


public interface MovieService {
	
	List<Movie> createPlaylist(UUID userId,Long id);
	List<Movie> fetchAllMovies();
	Movie findById(Long id);
	void addMovie(Movie movie);
}
