import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapUtility {

	public static void main(String[] args) {
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		map.put("key1", Arrays.asList(1, 2, 3, 4));
		map.put("key2", Arrays.asList(4, 5, 6, 7));
		map.put("key3", Arrays.asList(8, 9, 10, 11));
		map.put("key4", Arrays.asList(12, 13, 14, 15));

		for (Map.Entry<String, List<Integer>> mapIter : map.entrySet()) {
			List<Integer> li = mapIter.getValue();
			for (Integer num : li) {
				if (num % 2 == 0) {
					System.out.println(num);
				}
			}
		}
	}

}
