import java.util.Scanner;

public class PldStr {

	    public static void main(String args[]) {
	        // Your Code Here
	        Scanner sc = new Scanner(System.in);
	        String input = sc.next();
	        int len = input.length();
	        int arr[][] = new int [len][len];
	        System.out.println(countPalindromicSubString(input, arr));
	    }


	    public static int countPalindromicSubString(String input , int [][] arr) {
	            int row = 0 ;
	            int col = 0 ;
	            int count = 0;
	        while (row < arr.length && col < arr.length) {
	            arr[row][col] = 1;
	            row++; col++;
	            count++;
	        }
	        row = 0; col = 1;
	        while (row < arr.length && col < arr.length) {
	            if (input.charAt(row)==input.charAt(col)) {
	                arr[row][col] = 1;
	                count++;
	            } else {
	                arr[row][col] = 0;
	            }
	            row++;
	            col++;
	        }

	        for (int i = 2 ; i < arr.length ; i++) {
	            row = 0;
	            col = i;
	            
	            while(row < arr.length && col < arr.length) {
	                 if (arr[row+1][col -1] == 1 && input.charAt(row) == input.charAt(col)) {
	                     arr[row][col] = 1;
	                     count++;
	                 } else {
	                     arr[row][col] = 0;
	                 }
	                 row++;
	                 col++;
	            }
	        }
	    return count;
	    }

	}

