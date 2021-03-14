package Maths;

import java.util.HashMap;
import java.util.Map;

public class PairDivisibleByM {

	public static void main(String[] args) {
		System.out.println((int) Math.pow(10, 9) + 7);
		int arr[] = { 5, 17, 100, 11 };
		int B = 28;
		 System.out.println(solve(arr, B));
	}

	public static int solve(int[] A, int B) {
        Map<Integer , Long> map = new HashMap<>();
        for (int i = 0 ; i < A.length ; i++) {
            A[i] %= B;
            Long value = map.putIfAbsent(A[i] , 1l);
            if (value != null) {
                Long mod_value = ((value% 1000000007) + 1)% 1000000007;
                map.put(A[i], mod_value);   
            }
        }
        
        Long totalPair = 0l;
        
        for (int i = 0 ; i < A.length ; i++) {
               int anotherNumber = (B - A[i]);
               if (anotherNumber == A[i]) {
                   totalPair += (map.get(anotherNumber) -1);
               } else if (A[i] == 0) {
                   totalPair += (map.get(A[i]) -1);
               } else if (map.containsKey(anotherNumber)) {
                   totalPair += map.get(anotherNumber);
               }
        }
        totalPair /= 2;
        totalPair %= 1000000007;
        return totalPair.intValue();
    }
}
