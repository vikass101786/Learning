package Maths;

public class ExcelColumnNumber {
	
	
	public static void main(String[] args) {
		System.out.println(titleToNumber("ABCD"));
		
		/*
		 * for (int i = 0 ; i < 9 ; i++) { System.out.println((int)Math.pow(2, i)); }
		 */
	}
	
	 public static int titleToNumber(String A) {
	        
	        int number_representation = 0;
	        int pow = 0;
	        
	        for (int i = A.length()-1 ; i >= 0; i--) {
	               number_representation += (((int)A.charAt(i) - 64) * ((int)Math.pow(26, pow)));
	               pow++;
	        }
	        return number_representation;
	    }

}
