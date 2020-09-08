package TemplateDesignPattern;

public abstract class HouseConstruction {
	
	public final void buildHouse() {
		 constructPillars();
		 constructFoundation();
		 consturctWindows();
		 constructWalls();
		 System.out.println("House construction completed  \n ");
	}

	protected abstract void consturctWindows();

	protected abstract void constructWalls();

	private void constructPillars() {
		// TODO Auto-generated method stub
		System.out.println(" ||  || Create default Pillars ======= ||  || \n");
		
	}

	protected  void constructFoundation() {
		System.out.println(" || ^^-^^ || Create default foundation ======= || ^^-^^ || \n");
	};

}
