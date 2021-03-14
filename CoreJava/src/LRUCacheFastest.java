import java.util.LinkedHashMap;

public class LRUCacheFastest {
	
	LinkedHashMap<Integer, Integer> cache;
	
	/*public LRUCacheFastest(int capacity , boolean isLRU) {
		// TODO Auto-generated constructor stub
		cache = new LinkedHashMap<Integer, Integer>(capacity, 100.0f, isLRU) {
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
				//System.out.println(eldest.getKey() +" :: " + eldest.getValue());
				return size() > capacity;
			}
		};
	}*/
	
	public LRUCacheFastest(int capacity , boolean isLRU) {
		
		cache = new LinkedHashMap<Integer, Integer>(capacity, 100.0f, isLRU) {
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
				// TODO Auto-generated method stub
				return size() > capacity;
			}
		};
	}
	
	
	
	public int get(int key) {
		if(cache.containsKey(key))
			return cache.get(key);
		return -1;
	}
	
	public void set(int key, int value) {
		cache.put(key, value);
	}
	
	public LinkedHashMap<Integer, Integer> stateOfCache() {
		return cache;
	}
	
	public static void main(String[] args) {
		LRUCacheFastest lru = new LRUCacheFastest(2 , false);
		lru.set(1, 10);
		System.out.println(lru.cache);
		
		lru.set(5, 12);
		System.out.println(lru.cache);
		
		System.out.println(lru.get(5));
		System.out.println(lru.cache);
		
		System.out.println(lru.get(1));
		System.out.println(lru.cache);
		
		System.out.println(lru.get(10));
		System.out.println(lru.stateOfCache());
		
		lru.set(6, 14);
		System.out.println(lru.cache);
		
		System.out.println(lru.get(5));
		System.out.println(lru.cache);
		
		lru.set(10, 40);
		System.out.println(lru.cache);
	}
	
}
