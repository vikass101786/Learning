package Recurssion;

import java.util.Scanner;

public class RatMazePrintRec {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		ratMaze(0,0,len,len,"");
	}
	
	public static void ratMaze(int sr , int sc , int er, int ec, String answer) {
		if (sr == er && sc == ec) {
			System.out.println(answer);
			return;
		}
		
		if(sr > er || sc > ec) {
			return;
		}
		
		ratMaze(sr+1, sc, er, ec, answer+"H");
		ratMaze(sr, sc+1, er, ec, answer+"V");
	}

}
