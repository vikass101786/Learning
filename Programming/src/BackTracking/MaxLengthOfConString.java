package BackTracking;

import java.util.Arrays;
import java.util.List;

public class MaxLengthOfConString {
	
	//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
	
	private int count = 0;
	
	public static void main(String[] args) {
		List<String> arr = Arrays.asList("un","iq","ue");
		System.out.println(new MaxLengthOfConString().maxLength(arr));
		List<String> arr1 = Arrays.asList("cha","r","act","ers");
		System.out.println(new MaxLengthOfConString().maxLength(arr1));
		List<String> arr2 = Arrays.asList("abcdefghijklmnopqrstuvwxyz");
		System.out.println(new MaxLengthOfConString().maxLength(arr2));
	}
	
	
	 public int maxLength(List<String> arr) {
	        maxLengthOfConcatString(arr, 0, "");
	        return count;
	 }
	
	public void maxLengthOfConcatString (List<String> arr , int index , String answer) {
		if(index == arr.size() && containsAllUniqueChar(answer)) {
			if(answer.length() > count) {
				count = answer.length();
			}
			return;
		}
		
		if(index >= arr.size()) 
			return;
		
		if(containsAllUniqueChar(answer)) {
		maxLengthOfConcatString(arr, index+1, answer + arr.get(index));
		maxLengthOfConcatString(arr, index+1, answer);	
		}
	}
	
	
	private boolean containsAllUniqueChar(String answer) {
		int arr [] = new int [26];
		for (int i = 0; i < answer.length() ; i++) {
			arr[answer.charAt(i) - 'a']++;
			if(arr[answer.charAt(i) - 'a'] > 1) {
				return false;
			}
		}
		return true;
	}
	

}
