package Stack;

import java.io.IOException;
import java.util.Scanner;

public class GasStation {
	public static void main(String args[]) throws IOException {
	      
	      Scanner sc = new Scanner(System.in);
	      int len = sc.nextInt();
	      int gas [] = new int [len];
	      int cost [] = new int [len];
	      
	      for (int i = 0 ; i < len ; i++) {
	         gas[i] = sc.nextInt();
	      }
	      
	      for (int i = 0 ; i < len ; i++) {
	         cost[i] = sc.nextInt();
	      }
	      System.out.println(gasStation(gas,cost));
	    }
	    
	    public static int gasStation( int [] gas, int [] cost) {
	      long tank = 0 , deficit = 0;
	      int start = 0;
	      for ( int i = 0 ; i < gas.length ; i++ ) {
	        tank += gas[i] - cost[i];
	        if(tank < 0) {
	          start++;
	          deficit += tank;
	          tank = 0;
	        }
	      }
	      
	      return (tank + deficit) >= 0 ? start : -1;
	    }
}
