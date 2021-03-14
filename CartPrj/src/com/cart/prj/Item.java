package com.cart.prj;

public class Item {
	
	private String name;
	
    private Integer price;
    
    private Integer priceAfterDiscount;
	
	public Item(String name , Integer price) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		this.priceAfterDiscount = price;
	}

	public String getItemName() {
		return name;
	}

	public Integer getItemPrice() {
		return price;
	}

	public Integer getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	public void setPriceAfterDiscount(Integer priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}
	
	
	
}
