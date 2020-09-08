package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SubTreeEqualsTOSum {
	
	static int arr [] ;
	
	static class Node {
		int data;
		Node left , right;
		
		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.left = this.right = null;
		}
		
	}
	
	public static int countSumOfNode(Node root , int sum) {
		if(root == null) return 0;
		int ans = 0;
		if(Sum(root) == sum) {
			ans = 1;
		}
		int left_SubTreeSum = countSumOfNode(root.left, sum);
		int right_SubTreeSum = countSumOfNode(root.right, sum);
		return ans + left_SubTreeSum + right_SubTreeSum;
	}
	
	private static int Sum(Node root) {
		// TODO Auto-generated method stub
		if(root == null) {
			return 0;
		}
		int left = Sum(root.left);
		int right = Sum(root.right);
		return root.data + left + right;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
	    arr = new int [length];
		for(int i = 0 ; i < length ; i++) {
			arr[i] = sc.nextInt();
		}
		int x = sc.nextInt();
		Node root = createTreeFromLevelOrder();
		System.out.println(countSumOfNode(root, x));
	}

	private static Node createTreeFromLevelOrder() {
		// TODO Auto-generated method stub
		if(arr.length < 1) {
			return null;
		}
		Queue<Node> queue = new LinkedList<Node>();
		int number = arr[0];
		Node root = new Node(number);
		queue.add(root);
		int i = 1;
		while (i < arr.length) {
			Node temp = queue.poll();
			temp.left = new Node(arr[i++]);
			queue.add(temp.left);
			if(i >= arr.length) {
				break;
			}
			temp.right = new Node(arr[i++]);
			if(i >= arr.length) {
				break;
			}
			queue.add(temp.right);
		}
		return root;
	}

}
