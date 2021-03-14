package com.prj.tictoc;

public class TicTocGame {
	
	
	public static void main(String[] args) {
		Board board = new Board();
		Move move1 = new Move(0, 0, Player.X);
		board.makeMove(move1);
		board.getCurrentBoard();
		Move move2 = new Move(0, 1, Player.O);
		board.makeMove(move2);
		board.getCurrentBoard();
		Move move3 = new Move(1, 1, Player.X);
		board.makeMove(move3);
		board.getCurrentBoard();
		Move move4 = new Move(0, 2, Player.O);
		board.makeMove(move4);
		board.getCurrentBoard();
		Move move5 = new Move(2, 2, Player.X);
		board.makeMove(move5);
		board.getCurrentBoard();
		Move move6 = new Move(1, 2, Player.O);
		board.makeMove(move6);
	}

}
