package com.goodTime.service;

import java.util.List;
import com.goodTime.model.Place;


public interface PlaceService {
	
	void createPlace(Place place);
	void deletePlace(long id);
	Place findPlaceById(long id);
	Place findPlaceByName(String name);
	Place updatePlace(Place place, long id);
	List<Place> findAllPlaces();

}
