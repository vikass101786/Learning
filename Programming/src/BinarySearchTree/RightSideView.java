package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import BinarySearchTree.BinaryTree.TreeNode;

public class RightSideView {
	
	public static void main(String[] args) {
		TreeNode root = BinaryTree.createTreeUsingPreOrder();
		RightSideView rv = new RightSideView();
		String ans = "";
		
		int height = heightOfTree(root);
		boolean arr [] = new boolean[height+1];
		printRecRightView(root , arr , 0);
		//printRightSideView(root,ans);
		System.out.println(ans);
		printRightSideViewUsingLevelOrderTraversal(root);
	}

	private static void printRecRightView(TreeNode root, boolean[] arr, int currentLevel) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		
		if (!arr[currentLevel]) {
			System.out.print(root.data + " ");
			arr[currentLevel] = true;
		}
		
		printRecRightView(root.right, arr, currentLevel+1);
		printRecRightView(root.left, arr, currentLevel+1);
		
	}

	/*private static TreeNode printRightSideView(TreeNode root, String answer) {
		// TODO Auto-generated method stub
		if(root == null) {
			return null;
		}
		if(root.left == null && root.right == null) {
			System.out.println(answer + root.data);
		}
		
		TreeNode right = printRightSideView(root.right, answer + root.data + " ");
		if(right == null) {
			TreeNode left = printRightSideView(root.left, answer + root.data + " ");
		}
		return root;
	}*/
	
	
	public static int heightOfTree(TreeNode node) {
		if(node == null)
			return 0;
		int left = heightOfTree(node.left);
		int right = heightOfTree(node.right);
		return Math.max(left, right) + 1;
	}
	
	
	
	private static void printRightSideViewUsingLevelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		TreeNode prev = null;
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp == null) {
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				if(prev != null) {
					System.out.print(prev.data + " ");
					}
			} else {
				prev = temp;
				if(temp.left != null) {
					queue.add(temp.left);
				}
				
				if(temp.right != null) {
					queue.add(temp.right);
				}
			}
		}
	}
}
