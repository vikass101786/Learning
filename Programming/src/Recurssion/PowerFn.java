

package Recurssion;

import java.util.*;

public class PowerFn {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int ext = sc.nextInt();
		long startOld = System.currentTimeMillis();
		System.out.println(fnExpPower(num,ext));
		long EndtOld = System.currentTimeMillis();
		System.out.println(EndtOld - startOld);
		
		long startNew = System.currentTimeMillis();
		System.out.println(fastFunction(num,ext));
		long EndtNew = System.currentTimeMillis();
		System.out.println(EndtNew - startNew);
	}

	
	static int fastFunction(int num , int power) {
		
		int out =  fnExpPower(num, (power/2));
		out *= out;
		/*
		 * if(power % 2 == 0) { return (out * out); } else { return ((out * out) * num);
		 * }
		 */
		
		
		if((power & 1) == 1) {
			return (out * num);
		}
		
		return out;
		
	}
	
	public static int fnExpPower(int num, int ext) {
		// TODO Auto-generated method stub
		
		if(ext == 1) {
			return num;
		}
		
		return fnExpPower(num, ext-1) * num;
	}
	
}
