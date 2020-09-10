package AdapterDesignPattern;

public class ObjectAdapterClient {
	
	public static void main(String[] args) {
		System.out.println(" Creating drawing of shapes... ");
		Drawing drawing = new Drawing();
		drawing.addShape(new Rectangle());
		drawing.addShape(new Circle());
		drawing.addShape(new GeometricShapeAdpater(new Rhombus()));
		drawing.addShape(new GeometricShapeAdpater(new Triangle()));
		
		System.out.println(" ================== ");
		
		drawing.draw();
		drawing.resize();
		
	}

}
