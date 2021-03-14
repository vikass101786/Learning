package String;

public class ClosestPalindrome {
	
	public static void main(String[] args) {
		System.out.println(new ClosestPalindrome().solve("aaaaaaaaaabaaaaaaaaa"));
	}
	
	 public String solve(String A) {
	        int left = 0;
	        int right = A.length() -1;
	        int diffChar = 0;
	        while(left < right) {
	            if (A.charAt(left) != A.charAt(right)) {
	                diffChar++;
	            }    
	            left++;
	            right--;
	        }
	        
	        if ((((A.length() & 1) == 1) && diffChar <= 1) || (((A.length() & 1) == 0) && diffChar == 1)) {
	            return "YES";
	        } else {
	            return "NO";
	        }
	    }
}
