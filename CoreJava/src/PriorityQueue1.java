import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue1 {
	
	public static void main(String[] args) {
		Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String,Integer>>(
		new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
	}

}
