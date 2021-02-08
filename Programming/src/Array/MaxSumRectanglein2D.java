package Array;

public class MaxSumRectanglein2D {
	
	
	public static void main(String[] args) {
		int arr[][] = new int[][] { { 1, 2, -1, -4, -20 },
            						{ -8, -3, 4, 2, 1 },
            						{ 3, 8, 10, 1, 3 },
            						{ -4, -1, 1, 7, -6 } };
            	System.out.println(arr[0].length);
            	findMaxSum(arr);
	}

	private static void findMaxSum(int[][] arr) {
		// TODO Auto-generated method stub
		
		
		  int col_num = arr[0].length;
		  int row_num = arr.length;
		  int ans = 0;
		  for (int col = 0 ; col < col_num ; col++ ) {
			  int rows [] = new int [row_num];
			  for (int col1 = col ; col1 < col_num ; col1++) {
				  	
				  for (int i = 0 ; i < row_num ; i++) {
					  rows[i] += arr[i][col1];
				  }
				  ans = Math.max(ans, kadanes(rows));
			  }
		  }
		 
		System.out.println(ans);
		
	}

	private static int kadanes(int[] rows) {
		// TODO Auto-generated method stub
		 int max_sum = Integer.MIN_VALUE; int current_sum = 0; 
		 
		 for (int i = 0 ; i < rows.length ; i++) {
			 current_sum += rows[i];
			 if(max_sum < current_sum) {
				 max_sum = current_sum;
			 }
			 if(current_sum <= 0) {
				 current_sum = 0;
			 }
			 
		 }
		 
		return max_sum;
	}

}
