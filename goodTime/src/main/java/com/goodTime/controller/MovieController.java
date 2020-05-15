package com.goodTime.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
