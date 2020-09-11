package JDK8Feature;

public class DefaultAndStaticMethod implements Interface1,Interface2 {


	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
	
	 public static void log() {
		 System.out.println("Log from Interface1");
	 }
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		Interface1.super.print();
	}

	@Override
	public void method1(String check) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}

 interface Interface1 {
	 
	 public void method1(String check);
	// void method1();
	public static void log() {
		 System.out.println("Log from Interface1");
	 }
	 default void print() {
		 System.out.println("Default method from Interface1");
	 }
}
 
 interface Interface2 {
	 public void method2();
	 default void print() {
		 System.out.println("Default method from Interface2");
	 }
	 public static void log() {
		 System.out.println("Log from Interface1");
	 }
 }