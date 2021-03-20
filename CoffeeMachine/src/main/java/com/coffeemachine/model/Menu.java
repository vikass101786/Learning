package com.coffeemachine.model;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;


public class Menu {
	
	private List<Beverage> listOfbeverages;
	
	public Menu() {
		listOfbeverages = new ArrayList<Beverage>();
	}
	
	public void addBeverages(@NonNull final Beverage beverage) {
		listOfbeverages.add(beverage);
	}
	
	public List<Beverage> getAllBeverages() {
		return new ArrayList<Beverage>(listOfbeverages);
	}
}
