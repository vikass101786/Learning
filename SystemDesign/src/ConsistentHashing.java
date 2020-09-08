import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing<T> {
	
	
	private final HashFunction hashFunction;
	private final int numberOfReplicas;
	private final SortedMap<Integer, T> circle = new TreeMap<Integer, T>();
	
	
	public ConsistentHashing(HashFunction hashFunction, int numberOfReplicas, List<T> nodeList) {
		// TODO Auto-generated constructor stub
		this.hashFunction = hashFunction;
		this.numberOfReplicas = numberOfReplicas;
		
		for(T node : nodeList) {
			add(node);
		}
	}


	public void add(T node) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < numberOfReplicas ; i++) {
			circle.put(hashFunction.hash(node.toString() + i), node);
		}
	}
	
	
	public void remove(T node) {		
		for (int i = 0 ; i < numberOfReplicas ; i++) {
			circle.remove(hashFunction.hash(node.toString()) + i);
		}
	}
	
	public T get(Object key) {
		if(circle.isEmpty()) {
			return null;
		}
		
		int hash = hashFunction.hash(key);
		
		if(!circle.containsKey(hash)) {
			SortedMap<Integer, T> tailMap = circle.tailMap(hash);
			hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		}
		
		return circle.get(hash);
	}
}
