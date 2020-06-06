package com.goodTime.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodTime.exception.BadRequestException;
import com.goodTime.exception.NotFoundException;
import com.goodTime.model.Message;
import com.goodTime.model.Place;
import com.goodTime.repository.PlaceRepository;
import com.goodTime.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService{
	
	@Autowired
	private PlaceRepository placeRepository;

	@Override
	public void createPlace(Place place) {
		findPlaceByName(place.getName());
		placeRepository.save(place);
		
	}

	@Override
	public void deletePlace(long id) {
		findPlaceById(id);
		placeRepository.deleteById(id);
		
	}
	
	@Override
	public Place findPlaceById(long id) {
		return placeRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException("Place with ID "+id+ " does not exist!"));
	}

	@Override
	public Place updatePlace(Place place, long id) {
		return placeRepository.save(place);
	}

	@Override
	public List<Place> findAllPlaces() {
		return placeRepository.findAll();
	}

	@Override
	public Place findPlaceByName(String name) {
		if(placeRepository.findByName(name) != null) {
			throw new BadRequestException("Place with name "+name+ " already exists in database!");
		}
		return placeRepository.findByName(name);
	}
}
