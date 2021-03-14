package com.prj.tictoc;

public enum Player {
	
	X('X'),O('O');
	
	char identity;
	
	Player(char identity) {
		this.identity = identity;
	}

	public char getIdentity() {
		return identity;
	}
}
