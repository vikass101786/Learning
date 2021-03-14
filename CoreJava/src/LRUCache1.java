import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LRUCache1 {
	
	Map<Integer, Integer> map;
	int capacity;
	List<Integer> li ;
	
	public LRUCache1(int capacity) {
		// TODO Auto-generated constructor stub
		map = new LinkedHashMap<Integer, Integer>();
		this.capacity = capacity;
	}
	
	
	public void set(Integer key , Integer value) {	
		if(map.containsKey(key)) {
			map.remove(key);
			map.put(key, value);
		} else if (map.size() == capacity)  {
				remove();
				map.put(key, value);
			} else {
				map.put(key, value);
			}
	}
	
	public Integer get(Integer key) {
		Integer ans = -1;
		if(map.containsKey(key)) {
			ans = map.get(key);
			map.remove(key);
			map.put(key, ans);
		}
		return ans;
	}
	
	private void remove() {
		li = new ArrayList<Integer>(map.keySet());
		map.remove(li.get(0));
	}
	
	
	public static void main(String[] args) {
		LRUCache1 lr = new LRUCache1(2);
		lr.set(2, 1);
        lr.set(1, 1);
        lr.set(2, 3);
        lr.set(4, 1);
        System.out.println(lr.get(1));
        System.out.println(lr.get(2));
		/*
		 * System.out.println(lr.get(10)); lr.set(6, 14); System.out.println(lr.get(5));
		 */
	}

}
