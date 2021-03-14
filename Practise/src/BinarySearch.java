
public class BinarySearch {
	
	
	public static void main(String[] args) {
		int arr [] =  {1,2,3,4,5,6,7,8};
		for (int i = 0 ; i < arr.length ; i++) {
		System.out.println(binarySearch(arr, 0, arr.length, arr[i]));
		}
	}
	
	
	
	public static int binarySearch(int [] arr, int start , int end, int num) {
		if(start <= end) {
			int mid = (start + end)/2;
			
			if (arr[mid] == num) {
				return mid;
			}
			
			if (arr[mid] > num) {
				return binarySearch(arr, start, mid-1, num);
			} 
				return binarySearch(arr, mid+1, end, num);
		
		}
		return -1;
	}
	
	
}
