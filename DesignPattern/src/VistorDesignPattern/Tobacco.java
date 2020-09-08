package VistorDesignPattern;

public class Tobacco implements Visitable {

	public double price;
	
	public Tobacco(Double price) {
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
