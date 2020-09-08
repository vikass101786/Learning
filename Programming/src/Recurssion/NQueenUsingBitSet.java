package Recurssion;

import java.util.Scanner;

public class NQueenUsingBitSet {
	
	static boolean colArr [] = new boolean [30];
	
	static boolean d1 [] = new boolean [30];
	
	static boolean d2 [] = new boolean [30];
	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		
		int chessBoard [][] = new int[length][length];
		
		int row = 0 ;		
		solveNQueen(chessBoard , row , length );
	}



	private static void solveNQueen(int[][] chessBoard, int row, int length) {
		// TODO Auto-generated method stub
		
		if(row == length) {
			// print chess board
			for (int i = 0 ; i < length ; i++) {
				for (int j = 0 ; j < length ; j++) {
					if(chessBoard[i][j] == 1) {
						System.out.print(" Q");
					}else {
						System.out.print(" _");
					}
				}
				System.out.println();
			}
			
			System.out.println();
		}
		
		for(int col = 0 ; col < length ; col++) {
			
			if( !colArr[col] && !d1 [row - col + length -1] && !d2 [row + col] ) {
				chessBoard[row][col] = 1;
				colArr[col] = d1[row - col + length -1] = d2 [row + col] = true;
				solveNQueen(chessBoard, row+1, length);
				colArr[col] = d1[row - col + length -1] = d2 [row + col] = false;
			}
			
		}
		
	}
	
}
