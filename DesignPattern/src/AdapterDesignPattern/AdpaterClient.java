package AdapterDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class AdpaterClient {
	
	public static void main(String[] args) {
		System.out.println("Creating drawing of shapes....");
		Drawing drawing = new Drawing();
		drawing.addShape(new Rectangle());
		drawing.addShape(new Circle());
		
		System.out.println(" Drawing.....");
		drawing.draw();
		System.out.println(" Resizing....");
		drawing.resize();
		
		Map<String, Shape> map = new HashMap<String, Shape>();
		
	}
	
	
	
}
