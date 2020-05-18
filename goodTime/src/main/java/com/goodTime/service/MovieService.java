package com.goodTime.service;

import java.util.List;
import java.util.UUID;

import com.goodTime.model.Movie;


public interface MovieService {
	
	
	List<Movie> fetchAllMovies();
	Movie findMovieById(Long id);
	Movie updateMovie(Long id, Movie movie);
	void deleteMovieById(Long id);
	void addMovie(Movie movie);
}
