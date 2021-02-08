package Recurssion;

public class SudokuSolverCorrect {

	public static void main(String[] args) {

		int[][] sudokuBoard = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
								{ 6, 0, 0, 1, 9, 5, 0, 0, 0 },
								{ 0, 9, 8, 0, 0, 0, 0, 6, 0 },
								{ 8, 0, 0, 0, 6, 0, 0, 0, 3 },
								{ 4, 0, 0, 8, 0, 3, 0, 0, 1 },
								{ 7, 0, 0, 0, 2, 0, 0, 0, 6 },
								{ 0, 6, 0, 0, 0, 0, 2, 8, 0 },
								{ 0, 0, 0, 4, 1, 9, 0, 0, 5 },
								{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		sudokuSolverMachine(sudokuBoard, 0, 0);
	}

	private static boolean sudokuSolverMachine(int[][] sudokuBoard, int col, int row) {
		// TODO Auto-generated method stub
		if (col == sudokuBoard.length) {
			printSudokuBoard(sudokuBoard);
			return true;
		}

		if (row >= sudokuBoard[0].length) {
			return sudokuSolverMachine(sudokuBoard, col + 1, 0);
		}

		if (sudokuBoard[col][row] != 0) {
			return sudokuSolverMachine(sudokuBoard, col, row + 1);
		}

		for (int i = 1; i <= 9; i++) {
			if (canPlace(sudokuBoard, col, row, i)) {
				sudokuBoard[col][row] = i;
				boolean placedSuccessfully = sudokuSolverMachine(sudokuBoard, col, row + 1);
				if (placedSuccessfully) {
					return true;
				}
			}
		}
		// backtracking
		// Here its not backtracking to the previous index but current index is getting
		// updated as 0 which is already zero
		sudokuBoard[col][row] = 0;
		return false;
	}

	private static void printSudokuBoard(int[][] sudokuBoard) {
		// TODO Auto-generated method stub
		for (int i = 0; i < sudokuBoard.length; i++) {
			for (int j = 0; j < sudokuBoard[0].length; j++) {
				System.out.print(sudokuBoard[i][j] + " | ");
			}
			System.out.println();
		}
	}

	private static boolean canPlace(int[][] sudokuBoard, int y, int x, int i) {
		// TODO Auto-generated method stub
		int ySubArrIndex = (y / 3) * 3;
		int xSubArrIndex = (x / 3) * 3;

		for (int j = ySubArrIndex; j < ySubArrIndex + 3; j++) {
			for (int k = xSubArrIndex; k < xSubArrIndex + 3; k++) {
				if (sudokuBoard[j][k] == i)
					return false;
			}
		}

		for (int num = 0; num < 9; num++) {
			if (sudokuBoard[num][x] == i || sudokuBoard[y][num] == i) {
				return false;
			}
		}

		return true;
	}
}