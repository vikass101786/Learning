package Recurssion;

import java.util.Arrays;

public class AppleProblem {
	
	
	
	public static void main(String[] args) {
		int arr [] = {1,3};
		int n = arr.length;
		
		solution(arr,n);
	}

	public static void solution(int[] input2, int input1) {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(int i = 0 ; i < input2.length ; i++) {
			sum += input2[i];
		}
		
		int avg = sum/input2.length;
		
		Arrays.sort(input2);
		
		int left = 0;
		int right =input2.length -1;
		
		int move = 0;
		int extra = 0;
		int rem = 0;
		for(int i = 0 ; i <  input2.length  ;) {
			
			 if(extra == 0 && input2[right] > avg) {
				extra =  input2[right] - avg;
				input2[right] = avg; 
			 }
			
			if(input2[i] <= avg) {
			rem = avg - input2[i];
			} 
			 
			if(rem < extra ) {
				extra -= rem;
				move += rem;	
				input2[i] += rem; 
				 i++;
			} else {
				move += extra;
				input2[i] += extra; 
				extra = 0;
				right--;
			}
		}
			System.out.println(move);	
	}
			
}
