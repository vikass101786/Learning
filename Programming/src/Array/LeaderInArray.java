package Array;

public class LeaderInArray {
	
	
	public static void main(String[] args) {
		int arr [] = {16, 17, 4, 3, 5, 2};
		printLeaders(arr,arr.length);
	}

	private static void printLeaders(int[] arr, int length) {
	
		int maxTillNow = 0;
		
		for(int i= length-1 ; i > 0 ; i--) {
			if(arr[i] > maxTillNow) {
				System.out.print(arr[i] +" ");
				maxTillNow = arr[i];
			}
		}
	}
}
