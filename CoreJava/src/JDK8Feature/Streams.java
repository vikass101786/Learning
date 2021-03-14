package JDK8Feature;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Streams {
	
	
	public static void main(String[] args) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		List<List<Integer>> l1 = Arrays.asList(Arrays.asList(1,2,3,4,5),
									Arrays.asList(6,7,8,9,10),
									Arrays.asList(11,12,13,14,15));
		
		l1.stream().forEach(e -> System.out.println(e));
	}

}
