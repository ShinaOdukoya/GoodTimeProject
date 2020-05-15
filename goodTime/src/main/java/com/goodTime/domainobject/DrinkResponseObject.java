package com.goodTime.domainobject;

import org.springframework.data.rest.core.config.Projection;

import com.goodTime.model.Drink;

@Projection(name="drinkDetails", types= {Drink.class})
public interface DrinkResponseObject {
	
	String getName();
	long getPrice();
	long getQuantity();
	
}
