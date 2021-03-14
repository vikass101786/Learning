package ProblemSolving;

public class GetUniquePath {
	
	public static void main(String[] args) {
		System.out.println(uniquePath2(4, 5));
	}
	
	public static int uniquePathsFact(int A, int B) {
        return (fact((A-1)+ B)/ fact(A-1) * fact(B));
    }
    
    public static int fact(int num) {
        if (num == 0) {
            return 1;
        }
        int ans = 1;
        
        for (int i = 1 ; i <= num ; i++) {
            ans *= i;
        }
        return ans;
    }
    

	 public static int uniquePaths(int A, int B) {
	        
	        int arr [][] = new int [A][B];
	        
	        for (int i = 0 ; i < arr[0].length ; i++) {
	            arr [0][i] = 1;
	        }
	        
	        for (int i = 0 ; i < arr.length ; i++) {
	            arr [i][0] = 1;
	        }
	        
	        for (int i = 1  ; i < arr.length ; i++) {
	            for (int k = 1 ; k < arr[0].length ; k++) {
	                arr[i][k] = arr[i-1][k] + arr[i][k-1];
	            }
	        }
	        
	        return arr[A-1][B-1];
	    }
	 
	 
	 public static int uniquePath1(int M , int N) {
		 int [] dp = new int [N];
		 dp[0] = 1;
		 
		 for (int i = 0 ; i < M ; i++) 
			 for (int j = 1 ; j < N ; j++)
				 dp[j] += dp[j - 1];
		 
		 return dp[N-1];
	 }
	 
	 
	 public static int uniquePath2(int m , int n) {
		 int path = 1; 
			for (int i = n; i < (m + n - 1); i++) { 
				path *= i; 
				path /= (i - n + 1); 
			} 
			return path; 
	 }
	 
}
