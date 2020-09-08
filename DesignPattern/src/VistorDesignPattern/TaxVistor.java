package VistorDesignPattern;

public class TaxVistor implements Visitor {
	
	public TaxVistor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double visit(Liquor liquorItem) {
		// TODO Auto-generated method stub
		System.out.println("Liquor Item : Price with Tax");
		return ((liquorItem.getPrice() * 0.18 ) + liquorItem.getPrice());
	}

	@Override
	public double visit(Tobacco tobaccoItem) {
		System.out.println("Tobacco Item : Price with Tax");
		return ((tobaccoItem.getPrice() * 0.32 ) + tobaccoItem.getPrice());
	}

	@Override
	public double visit(Necessity necessityItem) {
		// TODO Auto-generated method stub
		System.out.println("Necessity Item : Price with Tax");
		return ((necessityItem.getPrice() * 0.001 ) + necessityItem.getPrice());
	}

}
