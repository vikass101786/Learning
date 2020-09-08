package Sorting;

public class QuickSort {
	
	
   public static void main(String[] args) {
	Integer arr [] = {7,2,1,6,8,5,3,4};
	sort(arr,0,arr.length-1);
	System.out.println(arr);
}

	private static void sort(Integer[] arr,int start , int end) {
		// TODO Auto-generated method stub
		if(start < end) {
			int pIndex = partition(arr,start,end);
			System.out.println(pIndex +"----" + arr[pIndex]);
			sort(arr,start,pIndex-1);
			sort(arr,pIndex+1,end);
		}
	}

	private static int partition(Integer[] arr, int start, int end) {
		// TODO Auto-generated method stub
		int pivot = arr[end];
		int pIndex = start;
		for(int i = start ; i < end ; i++) {
			if(arr[i] < pivot) {
				swap(arr,i,pIndex);
				pIndex++;
			}
		}
		swap(arr,pIndex, end);
		return pIndex++;
	}

	private static void swap(Integer [] arr,Integer integer, Integer integer2) {
		// TODO Auto-generated method stub
		int temp = arr[integer2];
		arr[integer2] = arr[integer];
		arr[integer]= temp;
	}
}
