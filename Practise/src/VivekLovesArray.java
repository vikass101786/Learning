import java.util.Scanner;

public class VivekLovesArray {
	
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int test_case = sc.nextInt();
	        for (int test = 0 ; test < test_case ; test++) {
	        int len = sc.nextInt();
	        int arr [] = new int [len];
	        int sum = 0;
	            for (int i = 0 ; i < len ; i++) {
	                arr[i] = sc.nextInt();
	                sum += arr[i];
	            }
	            if (sum % 2 == 0) {
	                System.out.println(maxPartition(arr,sum/2, 0 , arr.length-1));
	            } else {
	                System.out.println(0);
	            }
	        }
	    }

	    public static int maxPartition(int [] arr ,int sum, int start , int end) {
	        if(start >= end) {
	            return 0;
	        }

	        // find index
	        int index = 0;
	        int current_sum = 0;
	        for (int i = start ; i <= end ; i++) {
	            current_sum += arr[i];
	            if(current_sum == sum) {
	                index = i;
	                break;
	            }
	        }

	        if(index == end) {
	            return 0;
	        }
	       
	       if(sum %2 == 0) {
	    	   sum /= 2;
	       }
	       int left = maxPartition(arr , sum , start , index);
	       
	       int right = maxPartition(arr , sum , index+1 , end);

	        return Math.max(left,right)+1;
	    }

	}