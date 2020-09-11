package AdapterDesignPattern;

public class ObjectAdapterClient {
		
	
	// https://dzone.com/articles/adapter-design-pattern-in-java
	
	/*
	 * There are basically three types of Adpater 
	 * 1) Class Adapter - Every class will have its own Adpater 
	 * 2) Object Adapter - Each class of same type will have  common Adapter
	 * 3) Two Way Adapter - It can convert one type to another and vice-versa
	 */
	
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
