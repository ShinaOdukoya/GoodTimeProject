package com.goodTime.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodTime.model.Drink;
import com.goodTime.repository.DrinkRepository;
import com.goodTime.service.DrinkService;


@Service
public class DrinkServiceImpl implements DrinkService{
	
	@Autowired
	private DrinkRepository drinkRepository;

	@Override
	public void uploadDrink(Drink drink) {
		drinkRepository.save(drink);
		
	}

	@Override
	public void deleteDrinkById(long id) {
		drinkRepository.deleteById(id);
		
	}

	@Override
	public Drink updateDrink(Drink drink, long id) {
		return drinkRepository.saveAndFlush(drink);
	}

	@Override
	public Drink findDrinkById(long id) {
		return drinkRepository.findById(id).get();
	}

	@Override
	public List<Drink> findAllDrinks() {
		return drinkRepository.findAll();
	}

}
