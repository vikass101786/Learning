import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	Map<Integer, Node> map;
    Node start;
    Node end;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        start = new Node(0,0);
        end = new Node(0,0);
        this.capacity = capacity;
        start.next = end;
        end.prev = start;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addNode(node);

            return node.val;
        }

        return -1;
    }

    private void addNode(Node node) {
        node.next = start.next;
        start.next = node;
        node.prev = start;
        node.next.prev = node;
    }

    private void removeNode(Node node) {
        Node temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
    }

    public void set(int key, int value) {
        Node node = new Node(key, value);

        if (map.containsKey(key)) {
            Node temp = map.get(key);
            removeNode(temp);
            addNode(node);
        }
        else {
            if (capacity == map.size()) {
                Node temp = end.prev;
                removeNode(temp);
                map.remove(temp.key);
            }

            addNode(node);
        }

        map.put(key, node);
    }

    class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    
    
    public static void main(String[] args) {
		LRUCache lr = new LRUCache(2);
		lr.set(1, 10);
        lr.set(5, 12);
        System.out.println(lr.get(5));
        System.out.println(lr.get(1));
        System.out.println(lr.get(10));
        lr.set(6, 14);
        System.out.println(lr.get(5));
       
	}
    
}
