package com.coffeemachine.model;

import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;

public class Stock {

	/**
	 * key represents the id of Ingredients and value represents the available units
	 * in stock
	 */
	private Map<Integer, Integer> ingredientsAvailableQuantity;

	public Stock() {
		
		ingredientsAvailableQuantity = new HashMap<Integer, Integer>();
	}

	public void addIngredientsInStock(@NonNull final Integer id, @NonNull final Integer quantity) {
		
		Integer currentQuantity = ingredientsAvailableQuantity.putIfAbsent(id, quantity);
		if (currentQuantity != null) {
			ingredientsAvailableQuantity.put(id, currentQuantity + quantity);
		}
	}

	public boolean consumeIngredientFromStock(@NonNull final Integer id, @NonNull final Integer quantity) {
		
		if (ingredientsAvailableQuantity.containsKey(id)) {
			if (ingredientsAvailableQuantity.get(id) >= quantity) {
				ingredientsAvailableQuantity.put(id, ingredientsAvailableQuantity.get(id) - quantity);
				return true;
			}
		}
		return false;
	}

}
