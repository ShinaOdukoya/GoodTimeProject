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

import com.goodTime.model.Drink;
import com.goodTime.serviceImplementation.DrinkServiceImpl;

@RestController
@RequestMapping("api/drinks")
public class DrinkController {
	
	@Autowired
	private DrinkServiceImpl drinkService;
	
	@PostMapping("/")
	public ResponseEntity<Object> createDrink(@RequestBody @Valid Drink drink) {
		drinkService.uploadDrink(drink);
		return new ResponseEntity<>(drink, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity <List<Drink>> getDrinks(){
		List<Drink> allDrinks = drinkService.findAllDrinks();
		return new ResponseEntity <List<Drink>> (allDrinks, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Drink> getDrink(@PathVariable("id") long id){
		return new ResponseEntity <Drink> (drinkService.findDrinkById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Object> deleteDrink(@PathVariable("id") long id){
		drinkService.deleteDrinkById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
