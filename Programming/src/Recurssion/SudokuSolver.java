package Recurssion;

public class SudokuSolver {
	
	
	public static void main(String[] args) {
		
		 int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},  
                 		 {5, 2, 0, 0, 0, 0, 0, 0, 0},  
		                 {0, 8, 7, 0, 0, 0, 0, 3, 1},  
		                 {0, 0, 3, 0, 1, 0, 0, 8, 0},  
		                 {9, 0, 0, 8, 6, 3, 0, 0, 5},  
		                 {0, 5, 0, 0, 9, 0, 6, 0, 0},  
		                 {1, 3, 0, 0, 0, 0, 2, 5, 0},  
		                 {0, 0, 0, 0, 0, 0, 0, 7, 4},  
		                 {0, 0, 5, 2, 0, 6, 3, 0, 0}}; 
		 
		 int n = grid.length;
		 
		 int row = 0;
		 
		 int col = 0;
		 
		 System.out.println((4/(int)Math.sqrt(n))* (int)Math.sqrt(n));
		 
		 sudokuSolver(grid , n , row , col);
	}

	private static boolean sudokuSolver(int[][] grid, int n, int row, int col) {
		// TODO Auto-generated method stub
		
		
		//base Case 
		
		if(row == n -1 && col == n-1) {
			printGrid(grid);
		}
		
		
		for (;col < n ; col++) {
			if(isSafe(grid,row,col)) {
				for(int num = 1 ; num <= 9 ; num++) {
					if(canPut(num , grid , row , col)) {
						grid [row][col] = num;
						printGrid(grid);
						System.out.println();
						boolean canPlaceTheValue = true;
						
						if(col == n-1) {
							canPlaceTheValue = sudokuSolver(grid, n, row+1, 0);
						} else  {
							canPlaceTheValue = sudokuSolver(grid, n, row, col+1);
						}
						
						if(canPlaceTheValue) {
							return true;
						}
					}
				}
				grid [row][col] = 0;
				printGrid(grid);
				System.out.println();
				return false;
			}
		 }
		
		
		return true;
	}

	private static boolean canPut(int num, int[][] grid , int row , int col) {
		// TODO Auto-generated method stub
		
		// verify in the same row 
		
		for (int i = 0 ; i < grid.length ; i++) {
			if(num == grid[row][i]) {
				return false;
			}
		}
		
		// verify in the same column
		
		for(int i = 0 ; i < grid.length ; i++) {
			if(num == grid[i][col]) {
				return false;
			}
		}
		
		// verify in the same grid
		int sqrt = (int)Math.sqrt(grid.length);
		int startRow = (row/sqrt)* sqrt;
		
		int startCol = (col/sqrt)* sqrt;

		for (int rowVal = startRow ; rowVal < (startRow + sqrt) ; rowVal++) {
			for (int colVal = startCol ; colVal < (startCol + sqrt) ; colVal++) {
				if(grid[rowVal][colVal] == num) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void printGrid(int[][] grid) {
		for(int x = 0 ; x < grid.length ; x++) {
			for(int y = 0 ; y < grid.length ; y++) {
				System.out.print(" "+grid[x][y]);
			}
			System.out.println();
		}
	}
	
	private static boolean isSafe(int[][] grid, int row, int col) {
		// TODO Auto-generated method stub
		if(grid[row][col]==0) {
			return true;
		}
		return false;
	}
}
