package Sorting;

import java.util.HashMap;

public class GameOfBottles {

	public static void main(String[] args) {
		int arr[] = {1,2,3};
		System.out.println(new GameOfBottles().solve(arr));
	}

	public int solve(int[] A) {
        
        HashMap<Integer , Integer> map = new HashMap<>();
        Integer maxValueTillNow = Integer.MIN_VALUE;
        Integer number = 0;
        
        for (int i = 0 ; i < A.length ; i++) {
            Integer count = map.putIfAbsent(A[i] , 1);
            if (count != null) {
                map.put(A[i], count+1);
            }
            if (maxValueTillNow < map.get(A[i])) {
                maxValueTillNow = map.get(A[i]);
            }
        }
        
        
        
        return maxValueTillNow 	;
    }

}
