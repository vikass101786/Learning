package VistorDesignPattern;

public class Liquor implements Visitable {

	
	public double price;
	
	public Liquor(Double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	@Override
	public double accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}
