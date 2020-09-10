package AdapterDesignPattern;

public class GeometricShapeAdpater implements Shape {
	
	GeometricShape geometricShape;
	
	public GeometricShapeAdpater(GeometricShape geometricShape) {
		// TODO Auto-generated constructor stub
		this.geometricShape = geometricShape;
	}

	@Override
	public void draw() {
			geometricShape.shape();
	}

	@Override
	public void resize() {
		// TODO Auto-generated method stub
		System.out.println( description() + "Can't be resized. Please create new one with required values");
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		if(geometricShape instanceof Triangle) {
			return "Triangle Object";
		} else if (geometricShape instanceof Rhombus){
			return "Rhombus Object";
		} else {
			return "Unknown Object";
		}
	}

	@Override
	public boolean isHide() {
		// TODO Auto-generated method stub
		return false;
	}

}
