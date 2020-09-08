package VistorDesignPattern;

public class Necessity implements Visitable {

	public double price;
	
	public Necessity(Double price) {
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
