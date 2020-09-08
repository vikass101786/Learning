package TemplateDesignPattern;

public class WoodenHouse extends HouseConstruction {

	@Override
	protected void consturctWindows() {
		// TODO Auto-generated method stub
			System.out.println(" Windows as per wooden house \n");
	}

	@Override
	protected void constructWalls() {
		// TODO Auto-generated method stub
		System.out.println(" Wooden Walls and all other painting \n");
	}

}
