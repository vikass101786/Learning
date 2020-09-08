package Sorting;

public class QuickSortTry {
	
	public static void main(String[] args) {
		int arr [] = {7,2,1,6,8,5,3,4};
		quickSort(arr,0 , arr.length-1);
		System.out.println(arr);
	}

	private static void quickSort(int[] arr, int start , int length) {
		// TODO Auto-generated method stub
		if(start >= length) {
			return;
		}
		int pivot = length;
		int pIndex = 0;
		int i = 0;
		while(i < pivot) {
			if(arr[i] < arr[pivot]) {
				swap(arr , i , pIndex);
				pIndex++;
			}
			i++;
		}
		swap(arr, pIndex, pivot);
		quickSort(arr, 0 , pIndex-1);
		quickSort(arr, pIndex, pivot);
		
	}

	private static void swap(int[] arr, int i, int pivot) {
		int temp = arr[i];
		arr[i] = arr[pivot];
		arr[pivot] = temp;
	}
	
}
