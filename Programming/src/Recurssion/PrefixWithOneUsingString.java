package Recurssion;

import java.io.IOException;
import java.util.Scanner;

public class PrefixWithOneUsingString {
	  public static void main(String args[]) throws IOException {
		    
		    //write your code here
		    Scanner sc = new Scanner(System.in);
		    int testCases = sc.nextInt();
		    while(testCases-- > 0) {
		      int length = sc.nextInt();
		      int arr [] = new int [length];
		      arr[0] = 1;
		      printAllBinaryCombination("1",length,1,1);
		      System.out.println();
		    }
		    
		  }
		  
		  
		  public static void printAllBinaryCombination(String answer , int length , int i , int count) {
			  if(i == length) {
				  System.out.print(answer +" ");
				   return;
			  }
			  
			  printAllBinaryCombination(answer+"1", length, i+1, count+1);
			  if(count >= (i+1-count))
			  printAllBinaryCombination(answer+"0", length, i+1, count);
			  
		  }
		  
}
