package DivideAndConquer;

import java.io.IOException;
import java.util.Scanner;

public class DivideAndConquer {
	public static void main(String args[]) throws IOException {
	      
	      Scanner sc = new Scanner(System.in);
	      int num = sc.nextInt();
	      while(num-- > 0) {
	      int n = sc.nextInt();
	      System.out.println(sqrt(n));
	      }
	    }
	    
	    
	    public static long sqrt(int N) {
	      long left = 0;
	      long right = N;
	      long ans = 0;
	      while(left <= right) {
	    	  long mid = (left+right)/2;
	        if((mid * mid) > N) {
	          right = mid - 1;
	        } else if ((mid * mid) < N) {
	          ans = mid;
	          left = mid + 1;
	        } else {
	          ans = mid;
	          break;
	        }
	      }
	      return ans;
	    }
}
