package BinarySearch;

public class SpecialInteger {
	
	public static void main(String[] args) {
		int arr [] = {1, 2, 3, 4, 5};
		int B = 10;
		System.out.println(new SpecialInteger().solve(arr, B));
	}

    public int solve(int[] A, int B) {
        int ans = Integer.MIN_VALUE;
        long [] prefixArr = new long [A.length+1];
        prefixArr[1] = A[0];
        for (int i = 1 ; i < A.length ; i++) {
            prefixArr[i+1] = prefixArr[i] + A[i];
        }
        
        int left = 1;
        int right = A.length;
        
        while (left <= right) {
            int maxSubArrSize = (right - left)/2 + left;
            if (isPossible(prefixArr,B,maxSubArrSize)) {
                left = maxSubArrSize+1;
                ans = Math.max(ans,maxSubArrSize);
            } else {
                right = maxSubArrSize-1;
            }
        }
     return ans;   
    }
    
    
    private boolean isPossible(long [] prefixArr , int B, int arraySize) {
        
        for (int i = arraySize ; i < prefixArr.length ; i++) {
            if ((prefixArr[i] - prefixArr[i-arraySize]) > B) {
                return false;
            }
        }
        return true;
    }

}
