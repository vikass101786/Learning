
public class GCTest {
	public static void main(String[] args) throws InterruptedException {
		A a = new A("white");
		System.out.println("vikash".equalsIgnoreCase(null));
		/*
		 * for (int i = 0; i < 1000000000; i++) { if (i % 2 == 1) { a = new A("red"); }
		 * else { a = new A("green"); } a = null; }
		 */
		//Runtime.getRuntime().gc();
	}
}
 
class A {
	private String color;
 
	public A(String color) {
		this.color = color;
	}
 
	@Override
	public void finalize() {
		System.out.println(this.color + " cleaned");
	}
}
