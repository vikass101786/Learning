package Recurssion;

public class UnderstandingArrayRecursion {
	
	public static void main(String[] args) {
		int arr [] = new int [5];
		arrayRec(arr, 0);
	}

	private static void arrayRec(int[] arr , int i) {
		// TODO Auto-generated method stub
		if(i == arr.length) {
			return ;
		}
		
		arr[i] = i;
		printArray(arr);
		arrayRec(arr, i+1);
		printArray(arr);	
	}
	
	public static void printArray(int [] arr) {
		System.out.print("{ ");
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] +" ,");
		}
		System.out.println();
	}
	
}
