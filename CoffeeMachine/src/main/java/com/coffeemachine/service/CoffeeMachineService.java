package com.coffeemachine.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.coffeemachine.model.Beverage;

import lombok.NonNull;

public class CoffeeMachineService {
	private final List<Beverage> listOfBeverage;

	public CoffeeMachineService() {
		this.listOfBeverage = new ArrayList<Beverage>();
	}

	public void addBeverage(@NonNull Beverage beverage) {
		listOfBeverage.add(beverage);
	}

	public List<Beverage> getAllBeverage() {
		Collections.sort(listOfBeverage);
		return new ArrayList<Beverage>(listOfBeverage);
	}
		
}
