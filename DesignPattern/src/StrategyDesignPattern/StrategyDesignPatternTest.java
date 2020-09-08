package StrategyDesignPattern;

public class StrategyDesignPatternTest {
	public static void main(String[] args) {
		Bank bank = new Bank(200, 5, 2);
		bank.generateAmountAsPerInterestStrategy(new SimpleInterest("Rajendra"));
		bank.generateAmountAsPerInterestStrategy(new CompoundInterest("Rajendra", 2));
	}
	
}
