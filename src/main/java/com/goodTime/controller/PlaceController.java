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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.goodTime.model.Place;
import com.goodTime.serviceImplementation.PlaceServiceImpl;

@RestController
@RequestMapping("api/places")
public class PlaceController {
	
	@Autowired
	private PlaceServiceImpl placeService;
	
	@PostMapping("/")
	public ResponseEntity<Object> createPlace(@RequestBody @Valid Place place) {
		placeService.createPlace(place);
		return new ResponseEntity<>(place, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity <List<Place>> getPlaces(){
		List<Place> allPlaces = placeService.findAllPlaces();
		return new ResponseEntity <List<Place>> (allPlaces, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Place> getPlace(@PathVariable("id") long id){
		return new ResponseEntity <Place> (placeService.findPlaceById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Object> deletePlace(@PathVariable("id") long id){
		placeService.deletePlace(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
