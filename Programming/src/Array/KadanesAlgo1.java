package Array;

public class KadanesAlgo1 {
	
	
	public static void main(String[] args) {
		int arr [] = {-2, -3, 4, -1, -2, 1, 5, -3};
		kadanesAlgo(arr);
	}
	
	public static void kadanesAlgo(int [] arr) {
		
		int currentSum = arr[0];
		int maxSum = arr[0];
		int start = 0;
		int end = 0;
		int s = 0;
		
		for (int i = 1 ; i < arr.length ; i++) {
			
			currentSum += arr[i];
			
			if(currentSum > maxSum) {
				maxSum = currentSum;
				start = s;
				end = i;
			}
			
			if(currentSum <= 0) {
				currentSum = 0;
				s = i + 1;
			} 
			
		}
		
		System.out.println(" maxsum " + maxSum + " start :: " + start +" end :: " + end);
		
	}

}
