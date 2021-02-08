
public class Solution2 {
	
	public static void main(String[] args) {
		int arr [] = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
		System.out.println(new Solution2().singleNumber(arr));
	}
	
	 public int singleNumber(final int[] A) {
	        int arr [] = new int [32];
	        //int length = arr.length -1;
	        
	        for (int i = 0 ; i < A.length ; i++) {
	            int num = A[i];
	            for (int j = 31 ; num != 0 ; j--) {
	                arr[j] += (num & 1);
	                num >>= 1;
	            }
	        }
	        int num = 0;
	        int power = 31;
	        for (int k = 0 ; k <= 31 ; k++) {
	            if (arr[k] % 3 == 1)
	            num += Math.pow(2,power);
	            power--;
	        }
	        return num;
	    }
}
