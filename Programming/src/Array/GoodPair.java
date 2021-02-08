package Array;

import java.util.HashMap;
import java.util.Map;

public class GoodPair {
	
	
	public static void main(String[] args) {
		int A [] = { 6, 31, 33, 13, 82, 66, 9, 12, 69, 21, 17, 2, 50, 69, 90, 71, 31, 1, 13, 70, 94, 46, 89, 13, 55, 54, 67, 97, 28, 27, 62, 34, 41, 18, 15, 35, 13, 84, 93, 27, 89, 23, 6, 56, 94, 40, 54, 95, 47 };
		int B [] = {88, 85, 98, 36, 66, 40, 30, 26, 51, 77, 62, 60, 92, 64, 53, 86, 24, 53, 85, 49, 57, 29, 32, 60, 75, 82, 17, 23, 67, 51, 23, 11, 70, 59};
		new GoodPair().solve(A, B);
	}
	
	 public int[][] solve(int[] A, int[] B) {
	        
	        int ans [][] = new int [B.length][];
	        
	        for (int i = 0 ; i < B.length ; i++) {
	            int first_l = 0;
	            int partition_index = B[i] % A.length;
	            int first_r = partition_index-1;
	            int second_l = partition_index;
	            int second_r = A.length-1;
	            int temp [] = new int [A.length];
	            int k = 0;
	            
	            while(first_r >= first_l) {
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
	                int value = temp[l];
	                temp[l] = temp[r];
	                temp[r] = value;
	                l++;r--;
	            }
	            ans[i] = temp;
	        }
	        return ans;
	    }
}
