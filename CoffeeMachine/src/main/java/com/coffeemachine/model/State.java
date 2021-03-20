package com.coffeemachine.model;

public enum State {
	
	START(" Machine is Up and Idle "),
	DISPENSING(" Machine is working "),
	QUIT(" Machine Stopped ");

	String comment;

	private State(String comment) {
		this.comment = comment;
	}

}
