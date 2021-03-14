import java.util.HashMap;
import java.util.Map;

public class C {
	
	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	public C() {
		putMethod(this.getClass().getName());
	}
	
	
	public  void putMethod(String className) {
		if (map.containsKey(className)){
		throw new RuntimeException("Can't create instance more then once for class " + this.getClass().getName());	
		} else {
			System.out.println("============" + this.getClass().getName() + "===================");
			map.put(className, 1);
		}
	}
	
	public static void main(String[] args) {
		C c = new C();
		B b = new B();
		D d = new D();
		B b1 = new B();
		
	}

}

class B extends C {
	
}

class D extends B {
	
}