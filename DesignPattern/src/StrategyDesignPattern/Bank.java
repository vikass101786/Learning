package StrategyDesignPattern;

public class Bank {
	
	int amount;
	int time ;
	int rate;
	
	public Bank(int amount , int time , int rate) {
		// TODO Auto-generated constructor stub
		this.amount = amount;
		this.time = time;
		this.rate = rate;
	}
	
	
	public void generateAmountAsPerInterestStrategy(Interest interest) {
		interest.calculateinterest(amount, time, rate);
	}
	
}
