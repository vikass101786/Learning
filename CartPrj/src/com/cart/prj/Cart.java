package com.cart.prj;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

	private Map<Integer, Item> items = new HashMap<Integer, Item>();

	
	private int discountPrice;

	public Map<Integer, Item> getItems() {
		return items;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void addItemInCart(Integer sequence, Item item) {
		items.put(sequence, item);
	}

	public Integer calculateTotalPrice(Map<Integer, Discount> discount) {
		getDiscountedPrice(discount);
	    return items.entrySet().stream().
	    map(currentItem -> currentItem.getValue().getPriceAfterDiscount()).collect(Collectors.summingInt(Integer::intValue));
	}
	
	
	private void getDiscountedPrice(Map<Integer, Discount> discount) {
		discount.entrySet().stream().
		  forEach(currentDiscount -> 
		            currentDiscount.
		                 getValue().
		                getCoupon().
		                applyCoupon(currentDiscount.getKey() + 1 , items, currentDiscount.getValue().getDiscountValue()));
	}

}
