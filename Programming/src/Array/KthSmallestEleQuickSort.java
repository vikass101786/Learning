package Array;

public class KthSmallestEleQuickSort {
	
		public static void main(String[] args) {
			int arr [] = {12,3,5,7,19};
			System.out.println(KthSmallestEle(arr,0,arr.length -1 , 3));
		}
		
		static int KthSmallestEle(int [] arr , int l , int r , int k){
			
			if (k > 0 && k <= r - l + 1) 
			{ 
				// Partition the array around last 
				// element and get position of pivot 
				// element in sorted array 
				int pos = partition(arr, l, r); 

				// If position is same as k 
				if (pos-l == k-1) 
					return arr[pos]; 
				
				// If position is more, recur for 
				// left subarray 
				if (pos-l > k-1) 
					return KthSmallestEle(arr, l, pos-1, k); 

				// Else recur for right subarray 
				return KthSmallestEle(arr, pos+1, r, k-pos+l-1); 
			} 

			// If k is more than number of elements 
			// in array 
			return Integer.MAX_VALUE; 
		} 

		private static int partition(int[] arr, int start, int end) {
			// TODO Auto-generated method stub
			
			int pivot = arr[end];
			int partition = start;
			
			for(int i = start ; i < end ; i++) {
				if(arr[i] < pivot) {
					swap(arr , i , partition);
					partition++;
				}
			}
			
			swap(arr , partition , end);
			return partition;
		}

		private static void swap(int[] arr, int ele1, int ele2) {
			int temp = arr[ele1];
			arr[ele1] = arr[ele2];
			arr[ele2] = temp;
			
		}
}
