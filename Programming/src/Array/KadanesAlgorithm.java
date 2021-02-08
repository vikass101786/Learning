package Array;

public class KadanesAlgorithm {
		
	
	public static void main(String[] args) {
		//int arr [] = {-1,-2,-3,-4};
		int arr [] = {-2, -3, 4, -1, -2, 1, 5, -3};
		new Exception("Stack trace").printStackTrace();
		largestSubarrayPrb(arr,arr.length);
	}

	private static void largestSubarrayPrb(int[] arr, int length) {
		// TODO Auto-generated method stub
		int currentMax = arr[0];
		int maxTillNow = arr[0];
		int start = 0;
		int end = 0;
		int i;
		//new Exception("Stack trace").printStackTrace();
		Thread.dumpStack();
		for(i=1 ; i < arr.length ; i++) {
			currentMax += arr[i];
			//maxTillNow = Math.max(currentMax, maxTillNow);
			if(currentMax > maxTillNow) {
				maxTillNow = currentMax;
				end = i;
			}
			if((i+1) < arr.length  &&  arr[i+1] > 0) {
				if(currentMax < 0) {
					currentMax = 0;
					start = i+1;
				}
			}
		}
		System.out.println(maxTillNow + "  start : " + start +" end  : " + end);
	}
}
