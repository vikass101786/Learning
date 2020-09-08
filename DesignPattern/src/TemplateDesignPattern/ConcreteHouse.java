package TemplateDesignPattern;

public class ConcreteHouse extends HouseConstruction {

	@Override
	protected void consturctWindows() {
		// TODO Auto-generated method stub
		System.out.println(" Windows as per concrete house \n");

	}

	@Override
	protected void constructWalls() {
		// TODO Auto-generated method stub
		System.out.println(" Construct concrete walls , paint and all \n");
	}

}
