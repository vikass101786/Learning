package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.omg.PortableInterceptor.INACTIVE;

public class BST {

	static Scanner sc = new Scanner(System.in);
	static int tempBigger = 0;
	static int tempSmaller = 0;
	
	static class Node implements Cloneable {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
		
	}
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Node root = null;
		int d = sc.nextInt();
		while(d != -1) {
			root = buildBST(root, d);
			d= sc.nextInt();
		}
		Node copyNode = (Node)root.clone();
		inOrder(root);
		System.out.println();
		System.out.println(height(root));
		System.out.println();
		printLevelOrderTraversal(root);
		System.out.println();
		System.out.println(searchEleInTree(root, 13));
		System.out.println(searchEleInTree(root, 21));
		Node deleNode = deleteEle(root, 8);
		printLevelOrderTraversal(deleNode);
		System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		/*
		 * LinkedList1 ll = flatten(root); Node temp = ll.head;
		 * 
		 * while( temp != null) { System.out.print(temp.data + " -->"); temp =
		 * temp.right; }
		 */
		System.out.println();
		System.out.println("Reverse In Order");
		reverseInOrder(root);
		System.out.println();
		/*
		 * System.out.println("Bigger tree"); biggerTree(root);
		 * System.out.println(root);
		 */
		System.out.println("Smaller Tree");
		sumOfAllSmallNode(root);
		printLevelOrderTraversal(root);
		System.out.println();
		int arr [] = {1 ,2 , 3, 4 , 5, 6, 7, 8, 9};
		Node node = null;
		Node newNode = treeFromArray(node , arr , 0 , arr.length-1);
		printLevelOrderTraversal(newNode);
		
		int arr1 [] = {5123,3300,783,1111,890};
		System.out.println(canArrRepresentBST(arr1, Integer.MAX_VALUE, Integer.MIN_VALUE , 0));
		
	}
	
	private static Node treeFromArray(Node root1 ,int[] arr , int start , int end) {
		// TODO Auto-generated method stub
		if(start > end) return null;
		
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);
		node.left = treeFromArray(node.left ,arr, start, mid-1);
		node.right = treeFromArray(node.right ,arr, mid+1, end);
		
		return node;
	}

	public static Node buildBST(Node node , int d) {
		if(d == -1) {
			return null;
		}		
		
		if(node == null ) return new Node(d);
		if(node.data >= d) {
			node.left = buildBST(node.left,d);
		} else if(node.data < d) {
			node.right = buildBST(node.right,d);
		}
		return node;
	}
	
	public static void inOrder(Node node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.data + "==>");
		inOrder(node.right);
	}
	
	public static int height(Node node) {
		if(node == null) return 0;
		int lh = height(node.left);
		int rh = height(node.right);
		return 1 + Math.max(lh, rh);
	}
	
	public static void printLevelOrderTraversal(Node node) {
		Queue<Node> qe = new LinkedList<Node>();
		qe.add(node);
		qe.add(null);
		while(!qe.isEmpty()) {
			Node ele = qe.poll();
			if(ele == null) {
				System.out.println();
				if(!qe.isEmpty()) {
					qe.add(null);
				}
			}else {
				System.out.print(ele.data + " ");
				if(ele.left != null) {
					qe.add(ele.left);
				}				
				if(ele.right != null) {
					qe.add(ele.right);
				}
			}
		} 
	}
	
	static boolean searchEleInTree(Node root , int ele) {
		if(root == null) {
			return false;
		}
		if(root.data == ele) {
			return true;
		} else if (root.data >= ele) {
			return searchEleInTree(root.left, ele);
		} else {
			return searchEleInTree(root.right, ele);
		}
	}
	
	
	static Node deleteEle(Node root , int ele) {
		if(root == null) return null;
		if(root.data > ele) {
			root.left = deleteEle(root.left, ele);
		} else if(root.data < ele) {
			root.right = deleteEle(root.right, ele);
		} else {
			// if 1 child or No child
			
			if(root.left == null) {
				return root.right;
			}
			
			if(root.right == null) {
				return root.left;
			}
			
			// If 2 children
			
			 Node replace = root.right;
			
			
			if(replace != null) {
				replace = replace.left;
			}
			root.data = replace.data;
			root.right = deleteEle(root.right, replace.data);
		}
		return root;
	}
	
	static boolean isBST(Node root, Integer min , Integer max) {
		if(root == null) return true;
		if(root.data >= min && root.data <= max && isBST(root.left, min, root.data) && isBST(root.right, root.data, max)) {
			return true;
		}
		return false;
	}
	
	static class LinkedList1 {
		Node head;
		Node tail;
	}
		
	static LinkedList1 flatten(Node root) {
		LinkedList1 ll = new LinkedList1();
		
		if(root == null) {
			ll.head = ll.tail = null;
			return ll;
		}
		
		if(root.left == null && root.right == null) {
			ll.head = ll.tail = root;
			return ll;
		}
		
		if(root.left != null && root.right == null) {
			LinkedList1 llist = flatten(root.left);
			llist.tail.right = root;
			
			ll.head = llist.head;
			ll.tail = root;
			return ll;
		}
		
		if(root.left == null && root.right != null) {
			LinkedList1 llist = flatten(root.right);
			root.right = llist.head;
			
			ll.head = root;
			ll.tail = llist.tail;
			return ll;
		}
		
		LinkedList1 lleft = flatten(root.left);
		LinkedList1 lright = flatten(root.right);
		
		lleft.tail.right = root;
		root.right = lright.head;
		
		ll.head = lleft.head;
		ll.tail = lright.tail;
		
		return ll;
		
	}
	
	static void reverseInOrder(Node node) {
		if(node == null) return;
		reverseInOrder(node.right);
		System.out.print(node.data + "-->");
		reverseInOrder(node.left);
	}
	
	static void sumOfAllSmallNode(Node node) {
		if(node == null) return;
		sumOfAllSmallNode(node.left);
		node.data += tempSmaller;
		tempSmaller = node.data;
		sumOfAllSmallNode(node.right);
	} 
	
	static void biggerTree(Node node) {
		if(node == null) return;
		biggerTree(node.right);
		tempBigger = tempBigger + node.data;
		System.out.println(tempBigger);
		node.data = tempBigger - node.data;
		biggerTree(node.left);
	}
	
	//Check given array of size n can represent BST of n levels or not
	
	
	static boolean canArrRepresentBST(int [] arr , int max , int min , int i){
		System.out.println(max +  " " + min + " " + i +" " + arr[i]);
		if(i >= arr.length-1) {
			return true;
		}
		
		if(arr[i] > arr[i+1] && arr[i] < max && arr[i] > min) {
			System.out.println("========= LEFT ============");
			return canArrRepresentBST(arr, arr[i], min , i+=1);
		} else if (arr[i] < arr[i+1] && arr[i] < max && arr[i] > min) {
			System.out.println("========= RIGHT ============");
			return canArrRepresentBST(arr, max, arr[i] , i+=1);
		}
		
		System.out.println(" ===> " + max +  " " + min + " " + i +" " + arr[i]);
		return false;
	}
	
}
