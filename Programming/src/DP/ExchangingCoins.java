package DP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExchangingCoins {

	/*
	 * Tughlaq introduces a strange monetary system. He introduces copper coins and
	 * each coin has a number written on it. A coin n can be exchanged in a bank
	 * into three coins: n/2, n/3 and n/4. A coin can also be sold for gold. One can
	 * get as much grams of gold as the number written on the coin. You have one
	 * copper coin. What is the maximum weight of gold one can get from it?
	 * 
	 * Input Format The input file contains a single integer n, the number on the
	 * coin.
	 * 
	 * Constraints 0 <= n <= 1 000 000 000
	 * 
	 * Output Format Print the maximum weight of gold you can get.
	 * 
	 * Sample Input 12 Sample Output 13
	 */

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Long num = sc.nextLong();
		Map<Long, Long> map = new HashMap<Long, Long>();
		map.put(0L, 0L);
		System.out.println(maxGold(num, map));
	}

	public static long maxGold(Long num, Map<Long, Long> map) {

		if (num == 1)
			return 1;

		if (map.get(num) != null)
			return map.get(num);
		else {
			Long value = Math.max(num, maxGold(num / 2, map) + maxGold(num / 3, map) + maxGold(num / 4, map));
			map.put(num, value);
			return map.get(num);
		}

	}
}
