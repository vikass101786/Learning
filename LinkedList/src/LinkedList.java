
public class LinkedList {
	
	public static void main(String[] args) {
		
		System.out.println(Math.ceil(278.0/74.0) + Math.ceil(689.0/74.0));
		LinkedList ll = new LinkedList();
		for (int i = 9 ; i >= 1 ; i--) {
			ll.addNodeAtHead(i);
		}
		ll.printList();
		ll.reverseLL();
		ll.printList();
		ll.printList(ll.reversLLKNode(ll.head, 3));
	}

	Node head;

	public void addNodeAtHead(int data) {
		Node tempNode = new Node(data);
		if (head == null) {
			head = tempNode;
			return;
		}
		tempNode.next = head;
		head = tempNode;
	}
	
	public void reverseLL() {
		Node prev = null;
		Node current = head;
		
		while(current != null) {
			Node ahead = current.next;
			current.next = prev;
			prev = current;
			current = ahead;
		}
		head = prev;
	}
	
	public Node reversLLKNode(Node head , int K) {
		
		if (head == null) {
			return null;
		}
		
		Node temp = head;
		
		for (int i = 0 ; i < K ; i++) {
			temp = temp.next;
		}
		
		Node prev = reversLLKNode(temp, K);
		Node current = head;
		
		while(current != temp) {
			Node ahead = current.next;
			current.next = prev;
			prev = current;
			current = ahead;
		}
	return prev;	
	}
	
	public void printList(Node node) {
		Node iterNode = node;
		while(iterNode.next != null) {
			System.out.print(iterNode.data +" -> ");
			iterNode = iterNode.next;
		}
		System.out.print(iterNode.data + " ");
		System.out.println();
	}

	public void printList() {
		Node iterNode = head;
		while(iterNode.next != null) {
			System.out.print(iterNode.data +" -> ");
			iterNode = iterNode.next;
		}
		System.out.print(iterNode.data + " ");
		System.out.println();
	}
	
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}

}
