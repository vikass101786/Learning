package Maths;

public class ReverseInteger {
	
	public static void main(String[] args) {
		System.out.println(reverse(-1234567891));
	}
	
	 public static int reverse(int A) {
	        
	        boolean flag = (A < 0) ? false : true;
	        
	        if (!flag) {
	            A  = (A * -1);
	        }
	        
	        Long reverseNumber = 0l;
	        
	        while (A != 0) {
	            int num = A % 10;
	            reverseNumber = reverseNumber * 10 + num;
	            A /= 10;
	        }
	        
	        if (reverseNumber > 2147483647  || reverseNumber < -2147483647 ) {
	            return 0;
	        }
	        
	        if (!flag) {
	            reverseNumber = -1 * reverseNumber;
	        }
	        
	        return reverseNumber.intValue();
	    }
}
