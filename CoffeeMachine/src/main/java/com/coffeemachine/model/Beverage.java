package com.coffeemachine.model;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
public class Beverage implements Comparable<Beverage>{
	
	private final String id;
	
	private final String name;
	
	private final Integer cost;
	
	@ToString.Exclude
	private final List<Ingredients> requiredIngredientsList;
	
	public Beverage( @NonNull String id , @NonNull final String name , @NonNull final Integer cost , @NonNull final List<Ingredients> ingredientList) {
		 this.name = name;
		 this.cost = cost;
		 this.requiredIngredientsList = ingredientList;
		 this.id = id;
	}

	public int compareTo(Beverage o) {
		return o.name.compareTo(name);
	}
	
	
}
