package Array;

import java.util.*;
import java.io.*;

public class Main1 {
  public static void main(String args[]) throws IOException {
    
    //write your code here
    Scanner sc = new Scanner(System.in);
    int query = sc.nextInt();
    while(query-- > 0) {
      int arr1Length = sc.nextInt();
      int arr2Length = sc.nextInt();
      int arr1 [] = new int[arr1Length];
      int arr2 [] = new int[arr2Length];
      
      for (int i = 0 ; i < arr1Length ; i++) {
        arr1[i] = sc.nextInt();
      }
      
       for (int i = 0 ; i < arr2Length ; i++) {
        arr2[i] = sc.nextInt();
      }
      
      int finalArr [] = new int [arr1Length+arr2Length];
      
      System.out.println(findMedian(arr1,arr2,finalArr));
      
    }
  }
  
  public static int findMedian(int [] arr1 , int arr2 [] , int [] finalArr) {
    
    int k = 0;
    int l = 0;
    int m = 0;
    
    while(k < arr1.length && l < arr2.length) {
      if(arr1[k] < arr2[l]) {
         finalArr[m] = arr1[k];
         k++;m++;
      } else {
         finalArr[m] = arr2[l];
         l++;m++;
      }
    }
    
    while(k < arr1.length) {
       finalArr[m] = arr1[k];
         k++;
         m++;
    }
    
    while(l < arr2.length) {
       finalArr[m] = arr1[l];
         l++;
         m++;
    }
    
    int mid = finalArr.length/2;
    
    return finalArr[mid];
  }
  
}