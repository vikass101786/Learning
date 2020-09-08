package LL;

public class DriverDoubleLinkedList {
		
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addNodeAtStart(5);
		dll.addNodeAtStart(4);
		dll.addNodeAtStart(3);
		dll.addNodeAtStart(2);
		dll.addNodeAtEnd(10);
		dll.addNodeAtEnd(9);
		dll.addNodeAtEnd(8);
		dll.addNodeAtEnd(7);
		dll.addNodeAtStart(13);
		dll.addNodeAtIndex(100, 3);
		dll.addNodeAtIndex(200, 7);
	}
	
}
