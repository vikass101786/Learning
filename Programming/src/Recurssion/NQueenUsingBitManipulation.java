package Recurssion;

import java.util.Scanner;

public class NQueenUsingBitManipulation {
	
	static int mask;
	static int ans = 0;
	static int chessBoardSize;
	
	static int board[][] = new int [100][100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chessBoardSize = sc.nextInt();
		mask = ((1 << chessBoardSize)) -1;
		solve(0,0,0,0);
		System.out.println(ans);
	}

	private static void solve(int row, int rowMask, int leftDiagonal, int rightDiagonal) {
		// TODO Auto-generated method stub
		if(mask == rowMask) {
			
			for(int i = 0 ; i < chessBoardSize ; i++) {
				for(int j = 0 ; j < chessBoardSize ; j++) {
					System.out.print(board[i][j] +" ");
				}
				System.out.println();
			}
			System.out.println();
			ans++;
			return;
		}
		
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		int safe = mask & (~(rowMask|leftDiagonal|rightDiagonal));
		
		while(safe != 0) {
			int p = safe & (-safe);
			int col = getPosition(p);
			board[row][col] = 1;
			safe = safe - p;
			solve(row+1, rowMask|p, (leftDiagonal|p)<<1, (rightDiagonal|p)>>1);
			board[row][col] = 0;
		}
		
	}

	private static int getPosition(int p) {
		// TODO Auto-generated method stub
		int pos=0;
		while(p>0) {
			pos++;
			p = p >>1;
		}
		return pos-1;
	}
}
