package Recurssion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Factorial {
	
	static int y = 0;
		
	public static int fact(int n , Map map) {
		if(n == 0) return 1;
		System.out.println();
		ArrayList<Integer> al = (ArrayList<Integer>) map.get(n);
		if(al == null) al = new ArrayList<Integer>();
		int x = 0;
		System.out.println(x + "-- X before--" + y);
		x = y + 1;
		y = x;
		System.out.println(x + "-- X --");
		 al.add(-1);
		map.put(n,al);
		System.out.println(" n ==> " + n + "  MAP ===> " + map);
		int n1 = fact(n-1 , map);
		al.add(n1);
		map.put(n, al);
		System.out.println(x + "<<-- X -->>");
		System.out.println(" n1 ==> " + n1 + " n ==> " + n +" Map ===>> " + map);
		return n * n1;
	}
	
	public static void main(String[] args) {
		System.out.println("==========================");
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		Map map = new HashMap<Integer, ArrayList<Integer>>();
		
		System.out.println(fact(7,map));
		System.out.println("==========================");
	}
	
}
