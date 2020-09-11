package BinarySearchTree;

import BinarySearchTree.BinaryTree.TreeNode;


/* This problem is counting nodes specifically for complete nodes in log(N) time complexity, leveraging the properties of complete binary tree
 * 
 * Properties of complete binary tree
 * All the nodes will be filled at any level will be from left to right
 * Maximum nodes in any CBT for depth d => Math.pow(2, d); [2^d]
 * Minimum nodes in any CBT for depth d => Math.pow(2, d-1) ; [2^d-1];
 * Maximum nodes at any CBT for level l => Math.pow(2, l-1) ; 
 * 
 * So we count nodes in any CBT of depth d using this way
 * count_node =  count of nodes till (d-1) [numOfNodeTilldepthMinusOne] + nodes at last level [n_d]
 * count_node = Math.pow(2, d-1)  + n_d;
 * 
 * This Algorithm is mostly about how to calculate nodes at last level (n_d)
 * 
 *  We will apply binary search to calculate the node at last level
 * 
 * */


public class CountAllNodeInLog_N {
	public static void main(String[] args) {
		TreeNode root = BinaryTree.createTree();
		System.out.println(countAllNode(root));
	}

	private static int countAllNode(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		int depthOfTree = depth(root);
		if(depthOfTree == 1) {
			return 1;
		}
		
		int numOfNodeTilldepthMinusOne = (int)Math.pow(2, depthOfTree-1);
		
		// Maximum possible nodes at last level
		int left = 1;
		int right = (int)Math.pow(2, depthOfTree-1);
		int n_d = 0;
		while(left <= right) {
			int pivot = (left + right)/2;
			if(check(root,pivot,depthOfTree)) {
				left = pivot+1;
				n_d = left;
			} else {
				right = pivot-1;
			}
		}
		return numOfNodeTilldepthMinusOne + n_d;
	}

	private static boolean check(TreeNode root, int index, int depthOfTree) {
		// TODO Auto-generated method stub
		int left = 1;
		int right = (int)Math.pow(2, depthOfTree);
		
		for (int i = 0 ; i < depthOfTree ; i++) {
			int pivot = (left + right)/2;
			if(pivot <= index) {
				left = pivot+1;
				root = root.right;
			} else {
				right = pivot;
				root = root.left;
			}
		}
		return (root != null);
	}

	private static int depth(TreeNode root) {
		// TODO Auto-generated method stub
		int count = 0;
		if(root.left != null) {
			count++;
			root = root.left;
		}
		return count;
	}
	
}
