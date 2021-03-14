package com.prj.tictoc;

public class Board {

	final char[][] GRID;
	final int SIZE = 3;
	Status currentStatus = Status.UNDERGOING;

	public Board() {
		GRID = new char[SIZE][SIZE];
	}

	public void getCurrentBoard() {
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if (GRID[row][col] == 'X' || GRID[row][col] == 'O') {
					System.out.print(GRID[row][col] +" ");
				} else {
					System.out.print("_ ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void makeMove(Move move) {
		if (currentStatus != Status.DONE) {
			GRID[move.row][move.col] = move.getPlayer().getIdentity();
			if (identifyWinner(move)) {
				System.out.println(" Player " + move.getPlayer().getIdentity() + " won the match ");
				currentStatus = Status.DONE;
			}
		} else {
			System.out.println("****Match completed reset****");
		}
	}

	public void reset() {
		currentStatus = Status.UNDERGOING;
	}

	private boolean identifyWinner(Move move) {
		// TODO Auto-generated method stub
		boolean winRow = true, winCol = true, winDig = true, winRevDig = true;

		char player = move.getPlayer().getIdentity();

		for (int index = 0; index < SIZE; index++) {

			if (GRID[index][move.col] != player) {
				winRow = false;
			}
			if (GRID[move.row][index] != player) {
				winCol = false;
			}
			if (GRID[index][index] != player) {
				winDig = false;
			}
			if (GRID[index][SIZE - 1 - index] != player) {
				winRevDig = false;
			}
		}
		return winCol || winDig || winRevDig || winRow;
	}

}
