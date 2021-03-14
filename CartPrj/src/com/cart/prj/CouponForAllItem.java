package com.cart.prj;

import java.util.Map;

public class CouponForAllItem implements Coupon {

	@Override
	public void applyCoupon(Integer seq, Map<Integer, Item> itemList, Integer discountVal) {
		// TODO Auto-generated method stub
		for (int i = 0 ;  itemList.containsKey(i) ; i++) {
			 Item currentItem = itemList.get(i);
			 Integer discountValue = (currentItem.getItemPrice() * (100 -discountVal))/100; 
			 currentItem.setPriceAfterDiscount(discountValue);
		}
	}



}
