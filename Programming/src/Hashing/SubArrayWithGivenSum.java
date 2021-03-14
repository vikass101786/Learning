package Hashing;

public class SubArrayWithGivenSum {
	
	public static void main(String[] args) {
		int arr [] = {12, 1, 50, 39, 32, 23, 22, 44, 17, 5, 9, 12, 10, 50, 26, 5, 23, 38, 31, 5, 34, 8, 21, 11, 24, 44, 18, 19, 6, 31, 3, 47, 5, 2, 33, 44, 14, 9 };
		int B = 58;
		System.out.println(new SubArrayWithGivenSum().solve(arr, B));
	}
	
	 public int[] solve(int[] A, int B) {
	        
	        int startIndex = 0;
	        int endIndex = 0;
	        int sum = A[0];
	        boolean isPresent = false;
	        
	        for (int i = 1 ; i < A.length ; i++) {
	             if (sum > B) {
	                 while(sum > B) {
	                     sum = sum - A[startIndex];   
	                      startIndex ++;
	                   }
	             }
	             System.out.println(sum +" " + A[i]);
	             if (sum == B) {
	                   endIndex = i;
	                   isPresent = true;
	                   break;
	             } 
	             sum += A[i];
	        }
	        
	        int negativeArr [] = {-1};
	        
	        int len = (endIndex - startIndex);
	        int ansArr [] = (len < 0) ? new int [0] : new int [len];
	        int k = 0;
	        if (isPresent) {
	           for (int i = startIndex ; i < endIndex ; i++) {
	               ansArr [k++] = A[i];
	           } 
	        }
	         
	    return isPresent == true ? ansArr : negativeArr;
	    }

}
