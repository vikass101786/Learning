package StrategyDesignPattern;

public class SimpleInterest implements Interest {
	
	String name;
	
	
	public SimpleInterest(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void calculateinterest(int amount , int time , int rate) {

		// TODO Auto-generated method stub
		int totalAmount = amount * (1 + (rate * time));
		System.out.println(" Total amount to be paid by " + name + " in " + time + " Year is : " + totalAmount);
	
	}

}
