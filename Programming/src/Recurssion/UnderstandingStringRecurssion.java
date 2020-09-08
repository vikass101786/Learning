package Recurssion;

public class UnderstandingStringRecurssion {
	public static void main(String[] args) {
		String str = "";
		printStringRecursion(str , 0);
	}

	private static void printStringRecursion(String str , int k) {
		// TODO Auto-generated method stub
		if(str.length() == 5) {
			return;
		}
		
		System.out.println(str);
		
		printStringRecursion(str + k , k+1);
		
		System.out.println(str);
	}
}
