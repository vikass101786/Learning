package com.cart.prj;
import java.util.Map;

public interface Coupon {
	
	void applyCoupon(Integer seq ,Map<Integer, Item> itemList , Integer discountVal);
	
	
}
