import java.util.Arrays;
import java.util.List;

public class LambdaExp {
	
	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1,2,3,4,5);
		li.forEach(i -> System.out.print(i + " "));
	}
}
