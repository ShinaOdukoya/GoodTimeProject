package com.goodTime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.goodTime.demainobject.DrinkResponseObject;
import com.goodTime.model.Drink;
import com.goodTime.model.User;


@Repository
@RepositoryRestResource(collectionResourceRel = "drinks", path="drinks", excerptProjection=DrinkResponseObject.class)
public interface DrinkRepository extends JpaRepository<Drink, Long>{
	
}