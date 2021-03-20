package com.coffeemachine.api;

import java.util.List;

import com.coffeemachine.model.Beverage;
import com.coffeemachine.model.Ingredients;
import com.coffeemachine.service.CoffeeMachineService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoffeeMachineController {

	private final CoffeeMachineService coffeeMachineService;

	/*
	 * public List<String> displayMenu() { return coffeeMachineService
	 * .getAllBeverage() .stream() .map(beverage -> beverage.getName())
	 * .collect(Collectors.toList()); }
	 */

	public List<Beverage> displayMenu() {
		return coffeeMachineService.getAllBeverage();
	}
	
	public List<Ingredients> displayIngredients(Beverage beverage) {
		return beverage.getRequiredIngredientsList();
	}

}
