package com.prj.tictoc;

public class Move {
	int row, col;
	Player currentPlayer;
	
	
	public Move(int row, int col, Player currentPlayer) {
		this.row = row;
		this.col = col;
		this.currentPlayer = currentPlayer;
	}
	
	public Player getPlayer() {
		return currentPlayer;
	}

}
