package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MirrorTree {

	/*
	 *  15
	    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

		 1 
		 2  3 
		 4  5  6  7 
		 8  9  10  11  12  13  14  15 

		 1 
		 3  2 
		 7  6  5  4 
		 15  14  13  12  11  10  9  8 
	 * 
	 * 
	 * 
	 * */
	
	public static class TreeNode {
		TreeNode left , right;
		int data;
		
		public TreeNode(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			left = right = null;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int arr [] = new int [number];
		
		for (int i = 0 ; i < number ; i++) {
			arr[i] = sc.nextInt();
		}
		
		TreeNode node = createTree(arr);
		levelOrderTraversal(node);
		System.out.println("\n");
		TreeNode mirrorTree = mirrorTree(node);
		levelOrderTraversal(mirrorTree);
	}
	
	public static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp != null) {
				System.out.print( " " + temp.data + " ");
				if(temp.left != null) {
					queue.add(temp.left);
				}
				
				if(temp.right != null) {
					queue.add(temp.right);
				}
				
			} else {
				if(!queue.isEmpty()) {
					System.out.println();
					queue.add(null);
				}
			}
		}
		
	}


	private static TreeNode createTree(int[] arr) {
		// TODO Auto-generated method stub
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode node = new TreeNode(arr[0]);
		queue.add(node);
		int i = 1;
		
		while(i < arr.length) {
			TreeNode temp = queue.poll();
			
			temp.left = new TreeNode(arr[i++]);
			queue.add(temp.left);
			if(i >= arr.length) {
				break;
			}
			
			temp.right = new TreeNode(arr[i++]);
			queue.add(temp.right);
			if(i >=  arr.length) {
				break;
			}
		}
	return node;	
	}
	
	
	private static TreeNode mirrorTree(TreeNode node) {
		
		if(node == null) {
			return node;
		}
		
		
		TreeNode temp = node.left;
		node.left = mirrorTree(node.right);
		node.right = mirrorTree(temp);
	
		return node;
	}
	
}
