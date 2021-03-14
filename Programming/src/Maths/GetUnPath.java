package Maths;

public class GetUnPath {
	
	public static void main(String[] args) {
		uniquePaths(100	, 1);
	}
	
	 public static int uniquePaths(int A, int B) {
	        return (fact((A-1)+ B)/ fact(A-1) * fact(B));
	    }
	    
	    public static int fact(int num) {
	        
	        int ans = 1;
	        
	        for (int i = 1 ; i <= num ; i++) {
	            ans *= i;
	        }
	        return ans;
	    }
}
