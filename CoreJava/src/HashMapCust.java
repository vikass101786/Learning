public class HashMapCust<K, V> {

	final float loadFactor;
	int threshold;
	static final int MAXIMUM_CAPACITY = 1 << 30;
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	private Entry<K,V> table [];
	private Object [] lock;

	public HashMapCust() {
		this.loadFactor = .75f;
		this.getClass().getConstructors();
		table = new Entry[16];
		lock = new Object[16];
	}

	public V put(K key, V value) {
		return putVal(hash(key), key, value);
	}

	private V putVal(int hash, K key, V value) {
		// TODO Auto-generated method stub
		int index = index(hash);
		Entry<K, V> previousNode = null;
		Entry<K, V> newEntry = new Entry<K,V>(key, value, null, hash);
		if(table[index] == null) {
			synchronized (lock[index]) {
				table[index] = newEntry;
				lock[index].notifyAll();
			}
		} else {
			
			Entry<K, V> currentNode = table[index];
			while(currentNode != null) {
				synchronized ((lock[index]) ) {
					if(currentNode.getKey().equals(key)) {
						currentNode.setValue(value);
						break;
					}
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
				lock[index].notifyAll();
			}
			if(previousNode != null) {
				previousNode.setNext(newEntry);
			}
		}
		return previousNode != null ? previousNode.getValue() : null;
	}
	
	public V get(Object key) {
		Entry<K, V> e;
		return (e = getNode(hash(key), key)) == null ? null : e.value;
	}

	private Entry<K, V> getNode(int hash, Object key) {
		// TODO Auto-generated method stub
		int index = index(hash);
		Entry<K, V> node = table[index];
		while(node != null) {
			synchronized (lock[index]) {
				if(node.getKey().equals(key)) {
					break;
				}
				node = node.getNext();
			}
		}
		return node;
	}

	private int index(int hash) {
		// TODO Auto-generated method stub
		return hash & (DEFAULT_INITIAL_CAPACITY - 1);
	}

	static final int hash(Object key) {
		int h;
		if (key == null) {
			h = 0;
		} else {
			h = key.hashCode();
			h = h ^ (h >>> 16);
		}
		return h;
	}
	
	public void remove(K key){
        int index = index(hash(key));
        Entry previous = null;
        Entry entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)){
                if(previous == null){
                    entry = entry.getNext();
                    table[index] = entry;
                    return;
                }else {
                    previous.setNext(entry.getNext());
                    return;
                }
            }
            previous = entry;
            entry = entry.getNext();
        }
    }

	public static class Entry<K, V> {
		K key;
		V value;
		int hash;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next, int hash) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.value = value;
			this.next = next;
			this.hash = hash;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public int getHash() {
			return hash;
		}

		public void setHash(int hash) {
			this.hash = hash;
		}

		public Entry<K, V> getNext() {
			return next;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}

	}

	public static void main(String[] args) {
		HashMapCust<String,Integer> hm = new HashMapCust();
		Integer out ;
		out = hm.put("CLARK", 90);
		System.out.println(out);
		out = hm.put("BLAKE", 10);
		System.out.println(out);
		out = hm.put("FORD", 80);
		System.out.println(out);
		out = hm.put("SMITH", 100);
		System.out.println(out);
		out = hm.put("WARD", 70);
		System.out.println(out);
		out = hm.put("JONES", 60);
		System.out.println(out);
		System.out.println(hm.get("CLARK"));
	}

}