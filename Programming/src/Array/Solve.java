package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solve {
	
	public static void main(String[] args) {
		int arr [] = {11,17,100,5};
		solve(arr);
	}
	
	 public static int[] solve(int[] A) {
	        int ans [] = new int [A.length - 2];
	        
	        int unsoreted_arr [] = new int [A.length];
	        
	        for (int i = 0 ; i < A.length ; i++) {
	        	unsoreted_arr[i] = A[i];
	        }
	        
	        
	        Set<Integer> set = new HashSet<Integer>();
	        
	        Arrays.sort(A);
	             
	        for (int i = 0 ; i < A.length-2 ; i++) {
	        	set.add(A[i]);
	        }
	        int count = 0;
	        for (int i = 0 ; i < unsoreted_arr.length ; i++) {
	        	if (count < ans.length && set.contains(unsoreted_arr[i])) {
	        	//	System.out.print(unsoreted_arr[i] + " ");
	        		ans[count] = unsoreted_arr[i];
	        		count++;
	        	}
	        }
	        return ans;
	    }
}
