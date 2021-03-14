package ProblemSolving;

import java.util.Arrays;

public class MaxDiff {
	
	public static void main(String[] args) {
		int arr [] = {5, 17, 100, 11};
		int B = 3;
		System.out.println(solve(arr, B));
	}

    public static int solve(int[] A, int B) {
        
        Arrays.sort(A);
        int totalSum = 0;
        int subSetSum = 0;
        int subSetSumInvert = 0;
        int BInvert = A.length - B;
        for (int i = 0 ; i < A.length ; i++) {
            if(B > 0) {
                subSetSum += A[i];
                B--;
            }
            
            if (BInvert <= i) {
            	subSetSumInvert += A[i];
            }
            
            totalSum += A[i];
        }
        
        return Math.max(Math.abs(totalSum - 2*subSetSum), Math.abs(totalSum - 2*subSetSumInvert));
    }
    
    // 898 - 2*888

}
