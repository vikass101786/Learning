package BinarySearchTree; 

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	
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
	
}
