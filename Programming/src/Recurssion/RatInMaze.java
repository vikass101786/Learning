package Recurssion;

public class RatInMaze {
	
	static int count = 0;
	
	public static void main(String[] args) {
		char maze [][] = {{'0','0','0','0'},
						  {'0','0','0','0'},
						  {'0','0','0','X'},
						  {'0','X','0','0'}};
		/*System.out.println(*/countNoOfMaze(maze,0,0,4,4);//);
		System.out.println();
		System.out.println(count);
	}

	private static Boolean countNoOfMaze(char[][] maze, int row , int col, int lastRow , int lastCol) {
		
		if(row == lastRow-1 && col == lastCol-1) {
			maze[row][col]  = '1';
			for(int x = 0 ; x < lastRow ; x++) {
				for(int y = 0 ; y < lastCol ; y++) {
					System.out.print(" " + maze[x][y]);
				}
				System.out.println();
			}
			System.out.println();
			count++;
			//return false;
		}
		
		if(row > lastRow-1 || col > lastCol-1) {
			return false;
		}
		
		if(maze[row][col] == '1' || maze[row][col] == 'X') {
			return false;
		}
		
		maze[row][col]  = '1';
		
		Boolean moveRight = countNoOfMaze(maze, row, col+1, lastRow, lastCol);
		Boolean moveDown = countNoOfMaze(maze, row+1, col, lastRow, lastCol);
		
		maze[row][col]  = '0';
		
		if(moveRight || moveDown) {
			return false;
		}
		
		return false;
		
	}
	
}
