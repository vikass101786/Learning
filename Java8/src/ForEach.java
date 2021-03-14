import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {
	
 	class ConsImpl implements Consumer<Integer> {
		public void accept(Integer t) {
			// TODO Auto-generated method stub
			System.out.println(t);
		}
		
	};
	
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(4,3,7,6,5,8,4,3);
		
		System.out.println("=======WAY 1==========");
		
		Consumer<Integer> c = new ForEach().new ConsImpl();
		values.forEach(new ForEach().new ConsImpl());
		
		System.out.println("========WAY 2=========");
		
		values.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.print(t*2 + " ");
			}
		});
		
		System.out.println("========WAY 3=========");
		
		Consumer<Integer> cons =  t -> System.out.println(t+"values"+t);
		values.forEach(cons);
	}
}
