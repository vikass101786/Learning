package BinarySearchTree;

import java.util.Scanner;

import BinarySearchTree.BinaryTree.TreeNode;

public class RootToLeaf2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		Integer arr [] = new Integer [n];
		for (int i = 0 ; i < n ; i++) {
			arr [i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		
		TreeNode node = BinaryTree.createTree(arr);
		rootToLeaft(node,sum,0,"");
		
	}
	
	public static boolean check = false;

	private static void rootToLeaft(TreeNode node, int sum, int currentSum, String string) {
		// TODO Auto-generated method stub
		if(node == null) {
			if(currentSum == sum && !check) {
				check = true;
				System.out.println(string);
			}
			return;
		}
		
		
		rootToLeaft(node.left, sum, currentSum+node.data, string + node.data + " ");
		rootToLeaft(node.right, sum, currentSum+node.data, string + node.data + " ");
		
	}
}
