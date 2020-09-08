package LL;

import java.util.Scanner;
import java.util.Stack;

public class LinkedListCu {

	LinkedListNode head;

	public static class LinkedListNode {

		int data;
		LinkedListNode next;

		public LinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public LinkedListNode addNodeAtStart(int data) {
		if (head == null) {
			head = new LinkedListNode(data);
			return head;
		}

		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = head;
		head = newNode;
		return head;
	}

	public LinkedListNode addNodeAtEnd(int data) {
		if (head == null) {
			head = addNodeAtStart(data);
			return head;
		}
		LinkedListNode newNode = new LinkedListNode(data);
		LinkedListNode lastNode = traverseTillEnd(head);
		lastNode.next = newNode;
		newNode.next = null;
		return head;
	}

	public LinkedListNode addNodeInBetween(int data, int index) {

		LinkedListNode traversePartIndex = traverseToIndex(head, index);
		LinkedListNode newNode = new LinkedListNode(data);
		LinkedListNode nextNode = traversePartIndex.next;
		traversePartIndex.next = newNode;
		newNode.next = nextNode;
		return head;
	}

	private LinkedListNode traverseToIndex(LinkedListNode head, int index) {
		// TODO Auto-generated method stub
		LinkedListNode travNode = head;
		while (index-- > 0) {
			travNode = head.next;
			head = travNode;
		}
		return travNode;
	}

	private LinkedListNode traverseTillEnd(LinkedListNode head) {
		// TODO Auto-generated method stub
		LinkedListNode lastNode = head;
		while (head.next != null) {
			lastNode = head.next;
			head = lastNode;
		}
		return lastNode;
	}

	public LinkedListNode deleteNode(int index) {
		LinkedListNode traverserNode = traverseToIndex(head, index);
		traverserNode.next = traverserNode.next.next;
		return head;
	}

	public void printLinkedList(LinkedListNode node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		printLinkedList(node.next);

	}

	public LinkedListNode lastToFront(LinkedListNode head, int length) {
		LinkedListNode traverseNode = traverseTillEnd(head);
		LinkedListNode traverseTillBeforeLastNode = traverseToIndex(head, length - 2);
		traverseTillBeforeLastNode.next = null;
		head = addNodeAtStart(traverseNode.data);
		return head;
	}
	
	/*
	 * public LinkedListNode reverseLinkedList(LinkedListNode head) { if(head ==
	 * null || head.next == null) { return head; }
	 * 
	 * LinkedListNode next = reverseLinkedList(head.next);
	 * 
	 * next.next = head; head.next = null; return head;
	 * 
	 * }
	 */
	
	public LinkedListNode reverseRecursiveEasy(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        LinkedListNode reversedList = reverseRecursiveEasy(head.next);
        head.next.next = head;
        head.next = null;
        return reversedList;
    }

	public int findIndex(LinkedListNode head, int data) {
		int index = 0;
		while (head != null && head.data < data) {
			index++;
			head = head.next;
		}
		return index - 1;
	}
	
	public boolean isPalindrome(LinkedListNode node , int length) {
		int mid = 0;
		int first = 0;
		int second = 0;
		if(length % 2 != 0) {
		 mid = (length+1)/2;
		 first = mid - 1;
		 second = mid + 1;
		} else {
			mid = length/2;
			first = second = mid;
		}
		Stack<Integer> st = new Stack<Integer>();
		while(first-- > 0) {
			st.add(node.data);
			node = node.next;
		}
		
		LinkedListNode traverse = traverseToIndex(node, second - mid);
		while(!st.isEmpty() && traverse != null) {
			if(st.pop() != traverse.data) {
				return false;
			}
			traverse = traverse.next;
		}
		return true;
	}
	
	
	public LinkedListNode addOne(LinkedListNode node) {
		
		LinkedListNode traverseNode = node;
		int carry = 1 ; int sum = 0;
		
		while(traverseNode != null) {
			sum = traverseNode.data + carry;
			carry = (sum >= 10) ? 1 : 0;
			traverseNode.data = sum % 10;
			traverseNode = traverseNode.next;
		}
		
		if(carry > 0) {
			head = node;
			node = addNodeAtEnd(carry);
		}
		return node;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int query = sc.nextInt();
		while (query-- > 0) {
			int length = sc.nextInt();
			LinkedListCu ll = new LinkedListCu();
			for (int i = 0; i < length; i++) {
				ll.addNodeAtEnd(sc.nextInt());
			}
				ll.head = ll.reverseRecursiveEasy(ll.head);
				 ll.head = ll.addOne(ll.head);
				 ll.head = ll.reverseRecursiveEasy(ll.head);
				 ll.printLinkedList(ll.head);
				 System.out.println();
				 
				//System.out.println(ll.isPalindrome(ll.head, length));
			
			/*
			 * ll.printLinkedList(ll.head); System.out.println(); ll.head =
			 * ll.reverseRecursiveEasy(ll.head); ll.printLinkedList(ll.head);
			 * System.out.println();
			 */
			/*
			 * int nodeToBeInserted = sc.nextInt(); int index = ll.findIndex(ll.head,
			 * nodeToBeInserted); if (index <= 0) { ll.addNodeAtStart(nodeToBeInserted);
			 * ll.printLinkedList(ll.head); System.out.println(); } else {
			 * ll.addNodeInBetween(nodeToBeInserted, index); ll.printLinkedList(ll.head);
			 * System.out.println(); }
			 */
		}
	}

}
