package VistorDesignPattern;

public class TaxHoliday implements Visitor {
	
	public TaxHoliday() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double visit(Liquor liquorItem) {
		// TODO Auto-generated method stub
		System.out.println("Liquor Item : Price with Tax");
		return ((liquorItem.getPrice() * 0.28 ) + liquorItem.getPrice());
	}

	@Override
	public double visit(Tobacco tobaccoItem) {
		System.out.println("Tobacco Item : Price with Tax");
		return ((tobaccoItem.getPrice() * 0.52 ) + tobaccoItem.getPrice());
	}

	@Override
	public double visit(Necessity necessityItem) {
		// TODO Auto-generated method stub
		System.out.println("Necessity Item : Price with Tax");
		return ((necessityItem.getPrice() * 0.005 ) + necessityItem.getPrice());
	}


}
