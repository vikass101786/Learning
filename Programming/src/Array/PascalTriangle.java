package Array;

public class PascalTriangle {
	
	public static void main(String[] args) {
		System.out.println(new PascalTriangle().solve(0));
	}
	
	 public int[][] solve(int A) {
		    if (A == 0) {
		    	return new int [1][];
		    }
	        int ans [][] = new int [A][];
	        int temp [] = new int [1];
	        temp[0] = 1;
	        ans[0] = temp;
	        
	        for (int i = 2 ; i <= A ; i++) {
	            int arr [] = new int [i];
	            int K = 1;
	            arr [0] = 1;
	            for (;K < i-1 ; K++) {
	                arr [K] = ans[(i-1)-1][K-1] + ans[(i-1)-1][K];
	            }
	            arr [K] = 1;
	            ans [i-1] = arr;
	        }
	        return ans;
	    }
}
