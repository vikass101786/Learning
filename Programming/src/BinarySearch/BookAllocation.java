package BinarySearch;

import java.util.Scanner;

public class BookAllocation {
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int test_case = sc.nextInt();
	        while(test_case-- > 0) {
	            int len = sc.nextInt();
	            int student = sc.nextInt();
	            int arr [] = new int [len];
	            for (int i = 0 ; i < len ; i++) {
	                arr [i] = sc.nextInt();
	            }
	            System.out.println(bookAllocation(arr,student));
	        }

	    }

	    public static int bookAllocation(int [] arr , int student) {
	        int lo = 0;
	        int hi = 0;
	        for (int i = 0 ; i < arr.length; i++) {
	            hi += arr[i];
	        }

	        int answer = 0;
	        while(lo <= hi) {
	            int mid = (lo + hi)/2;

	            if(canRead(arr,mid, student)) {
	                hi = mid -1;
	                answer = mid;
	            } else {
	                lo = mid +1;
	            }
	        }
	        return answer;
	    }


	    public static boolean canRead(int [] pages , int maxRead, int student) {
	        int remaining = maxRead;
	        student--;
	        int i = 0;
	        for (;i < pages.length  && student >=0;) {
	            if(remaining >= pages[i]) {
	                remaining -= pages[i];
	                i++;
	            } else {
	                student--;
	                remaining = maxRead;
	            }
	        }

	         return i >= pages.length;
	    }
	}
