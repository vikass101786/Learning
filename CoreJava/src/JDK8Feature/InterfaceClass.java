package JDK8Feature;

public class InterfaceClass implements I1 ,I6,I2,I3,I4,I5 {

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

 
	




	@Override
	public void method2() {
		// TODO Auto-generated method stub
		I4.super.method2();
	}







	public static void main(String[] args) {
		new InterfaceClass().method2();
	}
	

}

interface I1 {
	void method1();
	
	default void method2() {
		System.out.println("from I1");
	}
}
interface I2 {
	void method1();
	default void method2() {
		System.out.println("from I2");
	}
}
interface I3 {
	void method1();
	default void method2() {
		System.out.println("from I3");
	}
}
interface I4 {
	void method1();
	default void method2() {
		System.out.println("from I4");
	}
}
interface I5 {
	void method1();
	default void method2() {
		System.out.println("from I5");
	}
}
interface I6 {
	void method1();
	default void method2() {
		System.out.println("from I6");
	}
}
