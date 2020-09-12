package BinarySearchTree; 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
	
	static Scanner sc = new Scanner(System.in);
	
	static class TreeNode {
		TreeNode left , right;
		int data;
		public TreeNode(int data) {this.data=data;}
	}
	
	public static TreeNode createTree(Integer arr []) {
		
		Queue<TreeNode> queue = new LinkedList<>();
		int i = 0;
		TreeNode node = new TreeNode(arr[i++]);
		queue.add(node);
		
		while(i < arr.length) {
			
			TreeNode temp = queue.poll();
			
			TreeNode left = new TreeNode(arr[i++]);
			queue.add(left);
			temp.left = left;
			if(i >= arr.length) {
				break;
			}
			
			TreeNode right = new TreeNode(arr[i++]);
			queue.add(right);
			temp.right = right;
			if(i >= arr.length) {
				break;
			}
			
		}
		return node;
	}
	
	public static TreeNode createTree() {
		int value = Integer.valueOf(sc.nextInt());
		TreeNode root = new TreeNode(value);
		boolean isExistLeft = sc.hasNextBoolean();
		if(isExistLeft) {
			root.left = createTree();
		}
		boolean isExistRight = sc.hasNextBoolean();
		if(isExistRight) {
			root.right = createTree();
		}
		
		return root;
	}
	
	public static TreeNode createTreeUsingPreOrder() {
		int value = sc.nextInt();
		if(value == -1) {
			return null;
		}
		TreeNode root = new TreeNode(value);
		root.left = createTreeUsingPreOrder();
		root.right = createTreeUsingPreOrder();
		return root;
	}
	
}
