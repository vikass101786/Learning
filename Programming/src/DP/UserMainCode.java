package DP;

import java.io.IOException;
import java.util.Scanner;



public class UserMainCode {
  public static void main(String args[]) throws IOException {
    
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();
    
    System.out.println(gemWars(N,M,X,Y));
  }
  
  
  public static int gemWars(int warriors , int gems , int evolvePoint , int killNdEvolve ) {
    
    int start = 0;
    int end = warriors;
    int ans = 0;
    int remGems = 0;
    int remWarrior = 0;
    while(start < end) {
      int mid = (start+end)/2;
      remWarrior = warriors - mid;
      remGems = gems - (mid*evolvePoint);
      if(remGems > 0) {
        start = mid+1;
      } else if((remWarrior > -1) &&  Math.abs(remGems) <= (remWarrior * killNdEvolve)) {
        end -= 1;
        gems += evolvePoint;
        start = mid+1;
        warriors -= 1;
        remGems = gems - (mid*evolvePoint);
      } else {
        start += 1;
      }
      if(remGems >= 0) {
      ans = mid;
      }
    }
    return ans;
  }
  
}
