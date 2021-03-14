package com.cart.prj;
import java.util.Map;

public class CouponForNextItem implements Coupon {

	@Override
	public void applyCoupon(Integer seq, Map<Integer, Item> itemList, Integer discountVal) {
		Integer priceAfterDiscount = (itemList.get(seq).getItemPrice() * (100 - discountVal))/100;
		itemList.get(seq).setPriceAfterDiscount(priceAfterDiscount);
	}





	

}
