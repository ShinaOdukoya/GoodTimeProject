package com.goodTime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.goodTime.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{
	
	Place findByName(String name);

}
