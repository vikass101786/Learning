package Array;

public class FindEleInSortAndRotArr {
  // Find the element in sorted and rotated Array
	
	public static void main(String[] args) {
		int arr [] = {5,6,7,8,9,10,1,2,3};
		printArray(arr);
		int key = 8;
		System.out.println(findEle(arr , key ,0 , arr.length));;
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
	
	private static int findEle(int[] arr, int key, int l, int h) {
		// TODO Auto-generated method stub
		if(l > h) return -1;
		int mid = (l+h)/2;
		
		if(arr[mid] == key) return mid;
		
		if(arr[l] <= arr[mid]) {
			if(key <= arr[mid] && key >= arr[l]) {
				return findEle(arr, key, l, mid);
			}else {
				return findEle(arr, key, mid, h);
			}
		}
		
		if(key >= arr[mid] && key <= arr[h]) {
			return findEle(arr, key, mid, h);
		}else {
			return findEle(arr, key, l, mid);
		}
		
	}
}
