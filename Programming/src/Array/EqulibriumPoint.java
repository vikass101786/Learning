package Array;

public class EqulibriumPoint {
	
	
	public static void main(String[] args) {
		int arr [] = { -7, 1, 5, 2, -4, 3, 0 };
		System.out.println(findEqulibriumPoint(arr , arr.length));
	}

	public static int findEqulibriumPoint(int[] arr, int length) {
		// TODO Auto-generated method stub
		int index = -1;
		int sum = 0;
		int rightSum = 0;
		
		for(int i = 0 ; i < length ; i++) {
			sum += arr[i];
		}
		
		
		for(int i = 0 ; i < length ; i++) {
			sum -= arr[i];
			System.out.println(" sum " + sum +" rightSum " + rightSum);
			if(sum == rightSum) {
				return i;
			}
			rightSum += arr[i];
		}	
		return index;
	}
}
