package Array;

import java.util.Arrays;

import BinarySearchTree.Solution;

public class Soution {
	
	public static void main(String[] args) {
		int A [] = {1, 2, 3, 3, 4};
		System.out.println(new Soution().solve(A, 7));
	}
	
	 public int solve(int[] A, int B) {

			Arrays.sort(A);
			int l = 0;
			int r = A.length - 1;
			int count = 0;
			while (l < r) {
				int sum = A[l] + A[r];
				if (B == sum) {
					count++;
					
				    while(l < r && A[l] == A[l+1] && l+1 != r){
				        l++;
				        count++;
				    } 
				    
				    while(l < r && A[r] == A[r-1] && r-1 != l) {
				        r--;
				        count++;
				    }
					l++;
					r--;
				} else if (B < sum) {
					r--;
				} else {
					l++;
				}
			}
			return count;
		}
}
