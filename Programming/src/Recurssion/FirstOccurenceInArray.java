package Recurssion;

public class FirstOccurenceInArray {
	
	public static void main(String[] args) {
		int arr [] = {10,30,40,30,90};
		System.out.println(findFirstOcc(arr,0,30));
		System.out.println(findLastOcc(arr,0,30));
	}

	private static int findFirstOcc(int[] arr, int i, int num) {
		// TODO Auto-generated method stub
		
		if(i >= arr.length) {
			return -1;
		}
		
		if(arr[i] == num) {
			return i;
		}
		
		return findFirstOcc(arr, i+1, num);
		
	}
	
	
	private static int findLastOcc(int [] arr , int i , int num) {
		
		if(i >= arr.length) {
			return -1;
		}
		
		int rr = findLastOcc(arr, i+1, num);
		
		if(arr[i] == num && rr == -1) {
			return i;
		}
		
		return rr;
	}
}
