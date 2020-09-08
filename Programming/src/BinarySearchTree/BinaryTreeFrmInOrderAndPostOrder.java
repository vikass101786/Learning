package BinarySearchTree;

import BinarySearchTree.MirrorTree.TreeNode;

public class BinaryTreeFrmInOrderAndPostOrder {
	
	public static int index ;
	
	public static void main(String[] args) {
		
		int in [] = {4 , 2 , 5, 1, 6 , 3, 7};
		int post [] = {4 , 5 , 2 , 6 , 7 , 3 , 1};
		index = in.length-1;
		TreeNode node = createTree(in, post, 0, in.length-1);
		MirrorTree.levelOrderTraversal(node);
	}
	

	
	public static TreeNode createTree(int in [] , int [] post , int start , int end) {
		if(start > end) {
			return null;
		}
		
		int value = post[index];
		index--;
		TreeNode root = new TreeNode(value);
		
		if(start == end) {
			return root;
		}
		
		int k = -1;
		for (int i = start ; i < end ; i++ ) {
			if(value == in[i]) {
				k = i;
				break;
			}
		}
		
		root.right = createTree(in, post, k+1, end);
		root.left = createTree(in, post, start, k-1);
		
		return root;
	}

}
