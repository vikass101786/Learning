package Recurssion;

import java.util.Scanner;

public class ConvertStringToInt {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		System.out.println(strToIntConverter(number)+00);
	}

	private static int strToIntConverter(String number) {
		// TODO Auto-generated method stub
		
		
		if(number.length() == 1) {
			return Integer.valueOf(number);
		}
		
		return Integer.valueOf(number.substring(0,1)) * (int)(Math.pow(10, number.substring(1).length())) + strToIntConverter(number.substring(1));
	}

}
