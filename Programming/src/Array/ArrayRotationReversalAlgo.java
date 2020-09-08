package Array;

import java.util.Arrays;

public class ArrayRotationReversalAlgo {
		
	
	public static void main(String[] args) {
		int arr [] = {1,2,3,4,5,6,7,8};
		int arr1 []= Arrays.copyOf(arr, arr.length);
		int d = 6;
		int dMod = d % arr.length;
		System.out.println(dMod);
		printArray(arr);
		rotateArr(arr,dMod,arr.length);
		printArray(arr);
		rotateArr(arr1,d,arr.length);
		printArray(arr1);
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		System.out.print("{");
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]);
			 if(i != arr.length -1 ) {
				 System.out.print(" ,");
			 }else {
				 System.out.print(" }");
			 }
		}
		System.out.println();
	}

	private static void rotateArr(int[] arr, int d, int length) {
		// TODO Auto-generated method stub
		reverseArray(arr,0,d-1);
		reverseArray(arr,d,length-1);
		reverseArray(arr,0,length-1);
	}

	private static void reverseArray(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		while(i<j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
}
