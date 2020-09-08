package Stack;

public class Trace {
	
	
	public void test1() {
		
	}
	
	public void test2() {
		test1();
	}
	
	public void test3() {
			test2();
		}
	
	public void test4() {
		System.out.println(Thread.currentThread().getStackTrace());
		Thread.dumpStack();
		test3();
	}
	
	public static void main(String[] args) {
		Trace t = new Trace();
		t.test4();
	}
	
}
