package AdapterDesignPattern;

public class Triangle implements GeometricShape {
	
	private final double a;
	private final double b;
	private final double c;
	
	public Triangle(double a, double b,double c) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Triangle() {
		this(1.0d,1.0d,1.0d);
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return a + b + c;
	}

	@Override
	public void shape() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Triangle with area: " + area() + " and perimeter: " + perimeter());
	}

	

}
