package Sorting;

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;
	import java.util.stream.Collectors;

public class UniqueElement {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23,
				72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54,
				54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80,
				39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62);
		int arr [] = {51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23,
				72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54,
				54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80,
				39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62};
		ArrayList<Integer> arrList = new ArrayList<Integer>(list);
		Collections.sort(arrList);
		System.out.println(arrList);
		System.out.println(new UniqueElement().solve(arr));
		ArrayList<Character> arr1 = new ArrayList<Character>();
		arr1.stream().map(value -> Character.toUpperCase(value)).collect(Collectors.toList());
	}

	 public int solve(int[] A) {
	        Arrays.sort(A);
	        int currentNum = A[0];
	        int sum = 0;
	        for (int i = 1 ; i < A.length ; i++) {
	            if (currentNum >= A[i]) {
	            	int temp = A[i];
	                A[i] = currentNum+1;
	                sum += (A[i] - temp);
	            }
                currentNum = A[i];
	        }
	        return sum;
	    }
}
