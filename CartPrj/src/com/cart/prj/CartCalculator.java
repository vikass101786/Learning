package com.cart.prj;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CartCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cart cart = new Cart();
		Integer sequence = 1;
		Map<Integer, Discount> couponList = new HashMap<Integer, Discount>();
		int count = 4;
		while (count-- > 0) {
			String str = sc.nextLine();
			if (str.indexOf('$') >= 0 && str.substring(0, 1).equals("$")) {
				String[] arr = str.split(" ");
				Integer itemPrice = Integer.valueOf(arr[0].substring(1));
				String itemName = "";

				for (int i = 1; i < arr.length; i++) {
					itemName += arr[i] +" ";
				}

				Item item = new Item(itemName, itemPrice);
				cart.addItemInCart(sequence, item);

			} else {

				int discount = Integer.valueOf(str.substring(str.indexOf("Take") + 5, str.indexOf("off") - 2));

				if (str.indexOf("next") != -1) {
					Discount discountOnNextProd = new Discount( discount, new CouponForNextItem());
					couponList.put(sequence, discountOnNextProd);
				} else if (str.indexOf("all") != -1) {
					Discount discountOnAllProd = new Discount( discount, new CouponForAllItem());
					couponList.put(sequence, discountOnAllProd);
				} else {

				}

			}
			sequence++;
		}
		System.out.println(cart.calculateTotalPrice(couponList));
	}

}
