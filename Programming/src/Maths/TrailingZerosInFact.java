package Maths;

public class TrailingZerosInFact {

	/*
	 * Trailing Zeros in Factorial
	 * 
	 * Given an integer A, return the number of trailing zeroes in A! i.e. factorial
	 * of A.
	 * 
	 * Note: Your solution should run in logarithmic time complexity.
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		System.out.println(trailingZeroes1(30));
		/*for (int i = 1; i <= 100; i++) {
			System.out.println(trailingZeroes(i) + " " + i);
		}*/
	}

	public static int trailingZeroes(int A) {

		int no_of_zeros = 0;
		int divisor = 5;

		while (divisor <= A) {
			no_of_zeros += (A / divisor);
			divisor *= 5;
		}

		return no_of_zeros;
	}
	
	public static int trailingZeroes1(int A) {
	    int num = 5;
	    int ans = 0;
	        while (A <= num) {
	            ans += (A/num);
	            num *= 5;
	        }
	      return ans;  
	    }

}
