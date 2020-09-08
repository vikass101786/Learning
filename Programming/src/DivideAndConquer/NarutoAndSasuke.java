package DivideAndConquer;

import java.io.IOException;
import java.util.Scanner;

public class NarutoAndSasuke {

    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      int naruto_power = sc.nextInt();
      int sasuke_power = sc.nextInt();
      int gems = sc.nextInt();
      int gem_can_inc_naruto_power = sc.nextInt();
      int gem_can_inc_sasuke_power = sc.nextInt();
      System.out.println(narsas(naruto_power,sasuke_power,gems,gem_can_inc_naruto_power,gem_can_inc_sasuke_power));
    }
    
    
    public static int narsas(int naruto_power , int sasuke_power , int gems , int gem_can_inc_naruto_power,int gem_can_inc_sasuke_power ) {
      
      int l = 0;
      int r = gems;
      int ans = 0;
      while(l <= r) {
          int mid = (l+r)/2;
          int A = naruto_power + (mid * gem_can_inc_naruto_power);
          int B = sasuke_power + (gems - mid) * gem_can_inc_sasuke_power;
          ans = mid;
          if(A < B) {
            l = mid+1;
          } else if (A > B){
            r = mid-1;
          } else {
        	  break;
          }
      }
      return ans;
    }
    
}
