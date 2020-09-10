package AdapterDesignPattern;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drwaing Rectangle");
	}

	@Override
	public void resize() {
		// TODO Auto-generated method stub
		System.out.println("Resizing Rectangle");
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Rectangle Object";
	}

	@Override
	public boolean isHide() {
		// TODO Auto-generated method stub
		return false;
	}

}
