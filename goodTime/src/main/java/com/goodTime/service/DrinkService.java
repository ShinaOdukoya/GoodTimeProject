package com.goodTime.service;

import java.util.List;
import com.goodTime.model.Drink;

public interface DrinkService {
	
	void uploadDrink(Drink drink);
	void deleteDrinkById(long id);
	Drink updateDrink(Drink drink, long id);
	Drink findDrinkById(long id);
	List<Drink> findAllDrinks();

}
