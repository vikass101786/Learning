package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(97, 86, 67, 19, 107, 9, 8, 49, 23, 46, -4, 22, 72, 4,
				57, 111, 20, 52, 99, 2, 113, 81, 7, 5, 21, 0, 47, 54, 76, 117, -2, 102, 34, 12, 103, 69, 36, 51, 105,
				-3, 33, 91, 37, 11, 48, 106, 109, 45, 58, 77, 104, 60, 75, 90, 3, 62, 16, 119, 85, 63, 87, 43, 74, 13,
				95, 94, 56, 28, 55, 66, 92, 79, 27, 42, 70));
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(list));
	}

	public int longestConsecutive(final List<Integer> A) {
        
        Collections.sort(A);
        
        int maxTillNow = 0;
        int ans = Integer.MIN_VALUE;
        
        for (int i = 1 ; i < A.size() ; i++) {
            if (Math.abs(A.get(i) - A.get(i-1)) == 1) {
                maxTillNow++;
            }else if (Math.abs(A.get(i) - A.get(i-1)) == 0){
                continue;
            } else {
                if (maxTillNow+1 > ans) {
                    ans = maxTillNow+1;
                }
                maxTillNow = 0;
            }
        }
       return ans < maxTillNow+1 ? maxTillNow+1 : ans;
    }
}
