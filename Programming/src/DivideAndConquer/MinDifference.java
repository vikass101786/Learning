package DivideAndConquer;

import java.util.*;

public class MinDifference {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int query = sc.nextInt();
		while(query-- > 0) {
			int length = sc.nextInt();
			int arr [] = new int [length];
			
			for (int i = 0 ; i < length; i++) {
				arr[i] = sc.nextInt();
			}
			
			int sum = sc.nextInt();
			
			System.out.println(minDiff(arr,sum));
		}
	}

	private static int minDiff(int[] arr, int sum) {
		// TODO Auto-generated method stub
		int diff = Integer.MAX_VALUE;
		for (int i = 0 ; i < arr.length - 2 ; i++) {
			
			int left = i+1;
			int right = arr.length - 1;
			
			while(left < right) {
				int currentSum = arr[left] + arr[right] + arr[i];
				int currentDiff = Math.abs(sum - currentSum);
				if(diff >= currentDiff) {
					diff = currentDiff;
				}
				if(currentSum == sum) {
					break;
				} else if (currentSum < sum) {
					left++;
				} else {
					right--;
				}
			}
			
		}
		
		return diff;
	}
	
}
