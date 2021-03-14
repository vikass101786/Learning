import java.util.Scanner;

public class MaxCirSum {
	
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int len = sc.nextInt();
	        int arr [] = new int [len];
	        for (int i = 0 ; i < len ; i++) {
	            arr[i] = sc.nextInt();
	        }
	        System.out.println(maxCircularSum(arr));
	    }

	    public static int maxCircularSum(int [] arr) {
	        int max_sum_till_now = 0;
	       int max_current_sum  = 0;
	       int min_sum_till_now = 0;
	       int  min_current_sum  = 0;
	       int array_sum = 0;

	        for (int i = 0 ; i < arr.length ; i++) {
	        
	        max_current_sum += arr[i];

	            if(max_current_sum < 0) {
	                max_current_sum = 0;
	            }

	            if (max_sum_till_now < max_current_sum) {
	                max_sum_till_now = max_current_sum;
	            }
	        
	        min_current_sum += arr[i];

	            if(min_current_sum > 0) {
	                min_current_sum = 0;
	            }

	            if(min_sum_till_now > min_current_sum) {
	                min_sum_till_now = min_current_sum;
	                
	            }

	            array_sum += arr[i];

	        }

	        int answer = 0 ;
	        System.out.println(max_sum_till_now +" " + min_sum_till_now + " " + array_sum);
	        if (array_sum == min_sum_till_now) {
	            answer = max_sum_till_now;
	        } else {
	            answer = Math.max(max_sum_till_now , (array_sum - min_sum_till_now));
	        }


	        return answer;
	    }

	  
	}