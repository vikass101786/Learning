package com.cart.prj;

public class Discount {
	
	private Integer discountValue;
	
	private Coupon coupon;

	public Integer getDiscountValue() {
		return discountValue;
	}
	
	
	public Discount(Integer discountValue, Coupon coupon) {
		this.discountValue = discountValue;
		this.coupon = coupon;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public void setDiscountValue(Integer discountValue) {
		this.discountValue = discountValue;
	}
	
	
	
}
