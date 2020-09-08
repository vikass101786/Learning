package LL;

import java.util.Scanner;

public class LLToReverse {
	
	public static Node head;
	
	public static class Node {
		Node next;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
			
	}
	
	
	public static void addNodeAtStart(int data) {
		Node newNOde = new Node(data);
		if(head == null) {
			head = newNOde;
			return;
		}	
		newNOde.next = head;
		head = newNOde;
	}
	
	public static void printLinkedList() {
		Node nodeToPrint = head;
		while(nodeToPrint != null) {
			System.out.print(nodeToPrint.data + " ");
			nodeToPrint = nodeToPrint.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int query = sc.nextInt();
		while(query-- > 0) {
			int length = sc.nextInt();
			
			for (int i = 0 ; i < length ; i++) {
				addNodeAtStart(sc.nextInt());
			}
			printLinkedList();
		}
	}
	
	public static void reverseLinkedList() {
		if(head == null) {
			return;
		}
		Node current = head;
		Node nextNode = head.next;
		
		if(nextNode == null) { 
			return;
		}
		
		
	}
}
