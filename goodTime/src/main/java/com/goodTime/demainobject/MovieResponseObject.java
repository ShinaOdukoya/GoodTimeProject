package com.goodTime.demainobject;

import org.springframework.data.rest.core.config.Projection;


import com.goodTime.model.Movie;

@Projection(name="movieDetails", types= {Movie.class})
public interface MovieResponseObject {

	Long getId();
	
	String getTitle();
	
	String getDescription();
}
