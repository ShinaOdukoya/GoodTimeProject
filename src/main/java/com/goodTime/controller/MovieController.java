package com.goodTime.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.goodTime.model.Movie;
import com.goodTime.serviceImplementation.MovieServiceImpl;



@RestController
@RequestMapping("api/movie")
public class MovieController {
	
	
	@Autowired
	private MovieServiceImpl movieService;
	
	@PostMapping("/")
	public ResponseEntity<Object> createMovie(@RequestBody @Valid Movie movie) {
		movieService.addMovie(movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}
	
	@GetMapping("/allMovies")
	public ResponseEntity<List<Movie>> fetchAllMovies(){
		List<Movie> allMovies = movieService.fetchAllMovies();
		return new ResponseEntity<List<Movie>>(allMovies, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity <Movie> getMovie(@PathVariable("id") Long id){
		return new ResponseEntity <Movie> (movieService.findMovieById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Movie> updateMovie(@PathVariable("id") Long id, @RequestBody @Valid Movie movie ){
		movieService.updateMovie(id, movie);
		return new ResponseEntity <> (movie, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Object> deleteMovie(@PathVariable("id") Long id){
		movieService.deleteMovieById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
