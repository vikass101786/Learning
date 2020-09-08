package VistorDesignPattern;

public class VisitorTest {
	
	public static void main(String[] args) {
		Visitor taxCalc = new TaxVistor();
		Visitor taxHolidayCalc = new TaxHoliday();
		
		Necessity water = new Necessity(3.00);
		Liquor red = new Liquor(18.00);
		Tobacco black = new Tobacco(50.00);
		
		System.out.println(water.accept(taxCalc) +"\n");
		System.out.println(red.accept(taxCalc) +"\n");
		System.out.println(black.accept(taxCalc) +"\n");
		
		System.out.println("TAX HOLIDAY CALC \n");
		
		System.out.println( water.accept(taxHolidayCalc) +"\n\n");
		System.out.println( red.accept(taxHolidayCalc) +"\n\n");
		System.out.println(black.accept(taxHolidayCalc) +"\n\n");
	}

}
