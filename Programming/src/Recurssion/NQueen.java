package Recurssion;

import java.util.Scanner;

public class NQueen {
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		
		int chessBoard [][] = new int[length][length];
		
		SolveNQueenProblem(chessBoard,0,length);
		
	}

	private static Boolean SolveNQueenProblem(int [][] chessBoard, int col, int n) {
		// TODO Auto-generated method stub
		if(col == n) {
			
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++) {
					if(chessBoard[i][j] == 1) {
						System.out.print(" Q");
					}else {
						System.out.print(" _");
					}
				}
				System.out.println();
			}
			
			System.out.println();
			return false;
		}
		
		for(int row = 0 ; row < n ; row ++) {
			
			if(isSafe(chessBoard,row,col,n)) {
				chessBoard[row][col] = 1;
				
				boolean canPlaceInNextCol = SolveNQueenProblem(chessBoard, col+1, n);
				
				if(canPlaceInNextCol) {
					return true;
				}
				chessBoard[row][col] = 0;
			}
			
		}		
		return false;
	}

	private static boolean isSafe(int [][] chessBoard, int row, int col, int n) {
		// TODO Auto-generated method stub
		
		for(int y = 0 ; y < col ; y++) {
			if(chessBoard[row][y] == 1) {
				return false;
			}
		 }
		
		int x = row , y = col;
		
		while(x >= 0 && y >= 0) {
			if(chessBoard[x][y] == 1) {
				return false;
			}
			x--;
			y--;
		}
		
		
		 x = row ; y = col;
		
		while(x < n && y >= 0) {
			if(chessBoard[x][y] == 1) {
				return false;
			}
			x++;
			y--;
		}
		
		return true;
	}

}
