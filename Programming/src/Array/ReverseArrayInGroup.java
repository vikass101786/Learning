package Array;

public class ReverseArrayInGroup {
		
	public static void main(String[] args) {
		int arr [] = new int [] {1,2,3,4,5};
		int k = 3;
		printArray(reverseArray(arr,k));
	}

	private static void printArray(int[] reverseArray) {
		// TODO Auto-generated method stub
		System.out.print("Merged Array = {");
		for(int i = 0 ; i < reverseArray.length ; i++) {
			System.out.print(reverseArray[i]);
			if( i != reverseArray.length -1) {
				System.out.print(" ,");
			}
		}
		System.out.print("}");
	}

	private static int [] reverseArray(int[] arr, int k) {
		// TODO Auto-generated method stub
		
		for(int i=0 ; i < arr.length ; i += k) {
			int left = i;
			int right = Math.min(i+k-1, arr.length-1);
			
			while(left < right) {
				int temp = arr[left]; 
				arr[left] = arr[right]; 
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return arr;
	}

	
}
