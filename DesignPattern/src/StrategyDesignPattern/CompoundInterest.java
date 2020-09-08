package StrategyDesignPattern;

public class CompoundInterest implements Interest {
	
	String name;
	
	int number_of_time;
	
	public CompoundInterest(String name , int numberOfTime) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.number_of_time = numberOfTime;
	}
	
	@Override
	public void calculateinterest(int amount , int time , int rate) {
		// TODO Auto-generated method stub
		double totalAmount = (double)amount * (Math.pow (1 + Math.floorDiv(rate, number_of_time), (number_of_time * time)));
		System.out.println(" Total amount to be paid by " + name + " in " + time + " Year is : " + totalAmount);
	}

}
