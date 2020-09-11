package BinarySearchTree;

import BinarySearchTree.BinaryTree.TreeNode;

public class AddOneRow {
	
	
	
	public static TreeNode addOneRow(TreeNode node, int level, int data) {
		// If level is 1 then create new node and add complete tree to left or right node
		if (level == 1) {
			TreeNode root = new TreeNode(data);
			root.left = node;
			return root;
		}
		return addOneRowToDifferentLevel(node,0 , level,data);
	}

	private static TreeNode addOneRowToDifferentLevel(TreeNode node,int currentLevel, int level, int data) {
		// TODO Auto-generated method stub
		
		if(currentLevel == level-1) {
			
			TreeNode left = node.left;
			TreeNode right = node.right;
			
			TreeNode left_child = new TreeNode(data);
			TreeNode right_child = new TreeNode(data);
			
			left_child.left = left;
			right_child.right = right;
			
			node.left = left_child;
			node.right = right_child;
			
		} else {
			addOneRowToDifferentLevel(node.left, currentLevel+1, level, data);
			addOneRowToDifferentLevel(node.right, currentLevel+1, level, data);
		}
		
		return node;
	}

}
