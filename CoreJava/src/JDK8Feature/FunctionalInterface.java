package JDK8Feature;

public class FunctionalInterface {
	
	Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			System.out.println(" Way of writing runnable method [Anonymus classes] before Java 8 ");
			
		}
	};
	
	Runnable r1 = () -> {
		System.out.println("Java 8 Way");
	};

	
	
	public static void main(String[] args) {
		Interface1 i1 = (s) -> System.out.println(s);
		i1.method1("abc");
	}
	
}
