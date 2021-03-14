import java.util.Scanner;

public class HourGlass {
	
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int num = sc.nextInt();
	        int row = num*2 + 1;
	        int col = num*2 + 1;
	        int pointer = num+1;

	        for (int i = 1 ; i <= num+1 ; i++) {
	            
	            for (int j = 1 ; j <= col ; j++) {
	                if(j < i) {
	                    System.out.print("  ");
	                }

	                if (j >= i && j <= num) {
	                    System.out.print(pointer - j +" ");
	                }
	                
	                if(j == num+1) {
	                System.out.print(0 +" ");
	                }

	                  if ( j > num+1 && j <= (row+1)-i) {
	                    System.out.print(j % pointer +" ");
	                }

	                 if(j-i >=  row) {
	                    System.out.print("  ");
	                }
	            }
	            System.out.println();
	        }
	        
	        for (int i = num ; i <= row ; i++) {
	            
	            for (int j = col ; j >= 0 ; j++) {
	                if(j < i) {
	                    System.out.print("  ");
	                }

	                if (j >= i && j <= num) {
	                    System.out.print(pointer - j +" ");
	                }
	                
	                if(j == num+1) {
	                System.out.print(0 +" ");
	                }

	                  if ( j > num+1 && j <= (row+1)-i) {
	                    System.out.print(j % pointer +" ");
	                }

	                 if(j-i >=  row) {
	                    System.out.print("  ");
	                }
	            }
	            System.out.println();
	        }
	    }
	}
