package TemplateDesignPattern;

public class TestTemplate {

		public static void main(String[] args) {
			
			HouseConstruction woondenHouse = new WoodenHouse();
			woondenHouse.buildHouse();
			
			System.out.println(" **************** \n");
			
			HouseConstruction concreteHouse = new ConcreteHouse();
			concreteHouse.buildHouse();
		}
		
}
