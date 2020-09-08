package Recurssion;

public class SudokuSolverCorrect {
	
	
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
		 
		 sudokuSolver(grid , n , row , col);
	
	}

	private static boolean sudokuSolver(int[][] grid, int n, int row, int col) {
		// Base Case
		
		if( row == n -1 && col == n -1 ) {
			printGrid(grid);
		}
		
		// Move to next row
		
		if(col == n) {
			sudokuSolver(grid, n, row+1, 0);
		}
		
		// Skip if pre-filled
		
		if(grid[row][col] != 0) {
			sudokuSolver(grid, n, row, col+1);
		}
		
		// recursive case
		
		for (int number = 1 ; number <= n ; number++) {
			if(isSafe(grid , number , row , col)) {
				grid[row][col] = number;
				printGrid(grid);
				boolean canWePutTheValue = sudokuSolver(grid, n, row, col+1);
				
				if(canWePutTheValue) {
					return true;
				}
			}
		}
	
		grid[row][col] = 0;
		printGrid(grid);
		return false;
	}
	
	private static boolean isSafe(int[][] grid, int number, int row, int col) {

		
		if(grid[row][col] != 0) {
			sudokuSolver(grid, grid.length, row, col+1);
		}
		
		// verify row 
		
		for (int x = 0 ; x < grid.length ; x++ ) {
			if(grid[x][col] == number) {
				return false;
			}
		}
		
		// verify column
		
		for (int y = 0 ; y < grid.length ; y++ ) {
			if(grid[row][y] == number) {
				return false;
			}
		}
		
		
		// verify grid
		
		int rn = (int)Math.sqrt(grid.length);
		int startRow = (row/rn)*rn;
		int startCol = (col/rn)*rn;
		
		for(int rowVal = startRow ; rowVal < (startRow+rn) ; rowVal++) {
			for(int colVal = startCol ; colVal < (startCol+rn) ; colVal++) {
				if(grid[rowVal][colVal] == number) {
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
		System.out.println();
	}
	
}	
