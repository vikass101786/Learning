package AdapterDesignPattern;

public class Circle implements Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drwaing circle");
	}

	@Override
	public void resize() {
		// TODO Auto-generated method stub
		System.out.println("Resizing Circle");
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Circle Object";
	}

	@Override
	public boolean isHide() {
		// TODO Auto-generated method stub
		return false;
	}

}
