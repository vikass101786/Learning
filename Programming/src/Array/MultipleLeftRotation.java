package Array;

public class MultipleLeftRotation {
	
	public static void main(String[] args) {
		int A [] = {1, 2, 3, 4, 5};
		int B [] = {2, 3};
		System.out.println(new MultipleLeftRotation().solve(A, B));
	}
	
	
	 public int[][] solve(int[] A, int[] B) {
	        
	        int ans [][] = new int [B.length][];
	        
	        for (int i = 0 ; i < B.length ; i++) {
	            int first_l = 0;
	            int first_r = B[i];
	            int second_l = first_r;
	            int second_r = A.length-1;
	            int temp [] = new int [A.length];
	            int k = 0;
	            
	            while(first_r > first_l) {
	                temp[k] = A[first_r--];
	                k++;
	            }
	            
	            while(second_r >= second_l) {
	                temp[k] = A[second_r--];
	                k++;
	            }
	            
	            int l = 0;
	            int r = A.length-1;
	            
	            while(l<=r) {
	                int value = A[l];
	                A[l] = A[r];
	                A[r] = value;
	                l++;r--;
	            }
	            ans[i] = temp;
	        }
	        return ans;
	    }
	
}
