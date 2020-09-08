package LL;

public class DoublyLinkedList {
	
	DoublyLinkedListNode head;
	
	
	public static class DoublyLinkedListNode {
		
		int data ; 
		DoublyLinkedListNode prev ;
		DoublyLinkedListNode next ;
		
		public DoublyLinkedListNode(int data) {
			this.data = data;
		}
		
	}
	
	
	public DoublyLinkedListNode addNodeAtStart(int data) {
		DoublyLinkedListNode dllNode = new DoublyLinkedListNode(data);
		if(head == null) {
			head = dllNode;
			return head;
		}
		
		dllNode.next = head;
		head.prev = dllNode;
		head = dllNode;
		return head;	
	}
	
	public DoublyLinkedListNode addNodeAtIndex(int data , int index) {
		DoublyLinkedListNode dllNode = new DoublyLinkedListNode(data);
		DoublyLinkedListNode traverseTillEnd = traverseTillIndex(head,index);
		DoublyLinkedListNode nexTNode = traverseTillEnd.next;
		traverseTillEnd.next = dllNode;
		dllNode.prev = traverseTillEnd;
		if(nexTNode != null) {
		dllNode.next = nexTNode;
		nexTNode.prev = dllNode;
		}
		return head;
		
	}
	
	public DoublyLinkedListNode addNodeAtEnd(int data) {
		DoublyLinkedListNode dllNode = new DoublyLinkedListNode(data);
		if(head == null) {
			head = addNodeAtStart(data);
			return head;
		}
		
		DoublyLinkedListNode traverseTillEnd = traverseAtEnd(head);
		traverseTillEnd.next = dllNode;
		dllNode.prev = traverseTillEnd;
		return head;
	}

	private DoublyLinkedListNode traverseAtEnd(DoublyLinkedListNode head) {
		DoublyLinkedListNode endNode = null;
		while(head.next != null) {
		   endNode = head.next;
		   head = endNode;
		}
		return endNode;
	}
	
	private DoublyLinkedListNode traverseTillIndex(DoublyLinkedListNode head , int index) {
		DoublyLinkedListNode endNode = null;
		while(index-- > 0) {
		   endNode = head.next;
		   head = endNode;
		}
		return endNode;
	}

}
