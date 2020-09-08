import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestConsistentHashing {
	
	public static <T> void main(String[] args) {
		HashFunction hashFunction = new PrimeMultiply();
		List<T> nodeList = (List<T>) Arrays.asList("192.168.0.1","192.168.0.2","192.168.0.3");
		ConsistentHashing<T>  consistentHashing = new ConsistentHashing<T>(hashFunction, 5, nodeList);
		System.out.println(consistentHashing.get("192.168.0.1"));
	}
	
}
