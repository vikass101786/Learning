package Recurssion;

import java.util.ArrayList;

public class RecurssionRevision {

	public static void main(String[] args) {

		int arr[] = { 1000, 5, 90, 80, 200 };

		System.out.println(findMaxEle(arr, 0));

		int arr1[] = { 20, 30, 10, 10, 40, 10 };

		System.out.println(firstOccIndex(arr1, 0, 50));
		System.out.println(lastOccurence(arr1, 0, 50));
		System.out.println(subSequence("abc"));
	}

	public static int findMaxEle(int arr[], int index) {
		if (index == arr.length - 1) {
			return arr[index];
		}

		int maxTillNow = findMaxEle(arr, index + 1);

		int max = Math.max(maxTillNow, arr[index]);

		return max;
	}

	public static int firstOccIndex(int[] arr, int index, int item) {

		if (index == arr.length) {
			return -1;
		}

		if (arr[index] == item) {
			return index;
		}

		return firstOccIndex(arr, index + 1, item);

	}
	
	public static int lastOccurence(int [] arr , int index , int item) {
		
		if (index == arr.length) {
			return -1;
		}
		
		int ans = lastOccurence(arr, index+1, item);
		
		if (arr[index] ==item) {
			ans = Math.max(ans, index);
		}
		
		return ans;
	}

	public static ArrayList<String> subSequence(String value) {
		
		if (value.isEmpty() || value.equals("")) {
			ArrayList<String> arr = new ArrayList<>();
			arr.add("");
			return arr;
		}
		
		Character firstChar = value.charAt(0);
		ArrayList<String> rr = subSequence(value.substring(1));
		ArrayList<String> newRr = new ArrayList<>();
		for (String word : rr) {
			newRr.add(word);
			newRr.add(firstChar+word);
		}
		return newRr;
	}
}
