package com.coffeemachine.model;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Beverage {
	
	private String name;
	
	private Integer cost;
	
	private List<Ingredients> requiredIngredientsList;
	
	public Beverage( @NonNull final String name , @NonNull final Integer cost , @NonNull final List<Ingredients> ingredientList) {
		 this.name = name;
		 this.cost = cost;
		 this.requiredIngredientsList = ingredientList;
	}
	
}
