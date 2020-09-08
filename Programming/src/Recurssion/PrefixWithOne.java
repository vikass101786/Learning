package Recurssion;

import java.util.*;
import java.io.*;

public class PrefixWithOne {
  public static void main(String args[]) throws IOException {
    
    //write your code here
    Scanner sc = new Scanner(System.in);
    int testCases = sc.nextInt();
    while(testCases-- > 0) {
      int length = sc.nextInt();
      int arr [] = new int [length];
      arr[0] = 1;
      printAllBinaryCombination(arr,length,1,1);
      System.out.println();
    }
    
  }
  
  
  public static void printAllBinaryCombination(int [] arr , int length , int i , int count) {
    if(i == arr.length) {
       for (int k = 0 ; k < length ; k++)
          System.out.print(arr[k]);
        System.out.print(" ");
        return;
    }
    
    if(i == length -1) {
      arr[i] = 1;
      printAllBinaryCombination(arr ,length ,i+1 ,count+1);
      if(count >= (i - count + 1)) {
        arr[i] = 0;
        printAllBinaryCombination(arr ,length ,i+1 ,count);
      }
    } else {
      arr[i] = 1;
      printAllBinaryCombination(arr ,length ,i+1 ,count+1);
      arr[i] = 0;
      printAllBinaryCombination(arr ,length ,i+1 ,count);
    }
  }
  
}
