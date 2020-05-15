package com.goodTime.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodTime.exception.NotFoundException;
import com.goodTime.model.Movie;
import com.goodTime.model.User;
import com.goodTime.repository.MovieRepository;
import com.goodTime.repository.UserRepository;
import com.goodTime.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void addMovie(Movie movie) {
		
		movieRepository.save(movie);
	}
	
	@Override
	public List<Movie> fetchAllMovies(){
		return movieRepository.findAll();
	}
	
	@Override
	public Movie findById(Long id) {
		
		return movieRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException("Movie with ID " + id + " not found!"));
	}
	
	@Override
	public List<Movie> createPlaylist(UUID userId, Long id){
		
		List<Movie> movies = fetchAllMovies();
		
		User user = userRepository.getOne(userId);
		
		List<Movie> movieplaylist = new ArrayList<>();
		
		
		
		
		
		user.setMovies(movieplaylist);
		
		userRepository.save(user);
		
		return movies;
		
	
		
	}

}
