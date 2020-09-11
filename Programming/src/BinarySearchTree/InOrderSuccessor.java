package BinarySearchTree;

import java.util.Scanner;

import BinarySearchTree.BinaryTree.TreeNode;

public class InOrderSuccessor {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		Integer arr [] = new Integer [n];
		for (int i = 0 ; i < n ; i++) {
			arr [i] = sc.nextInt();
		}
		int num = sc.nextInt();
		
		TreeNode node = BinaryTree.createTree(arr);
		inOrderSuccessorWay2(node,num);
		System.out.println(ans);
		System.out.println(inOrderSuccessorWay1(node, 2).data);
	}
	
	public static boolean check = false;
	public static Integer ans = null;

	private static void inOrderSuccessorWay2(TreeNode node, int num) {
		// TODO Auto-generated method stub
		if(node == null) return;
		inOrderSuccessorWay2(node.left, num);
		
		if(check) {
			check = false;
			ans = node.data;
		}
		
		if(node.data == num) {
			check = true;
		}
		
		inOrderSuccessorWay2(node.right, num);
		
	}
	
	private static TreeNode inOrderSuccessorWay1(TreeNode node , int num) {
		if(node == null) return null;
		TreeNode left = inOrderSuccessorWay1(node.left, num);
		if(left != null) return left;
		if(check) {
			return node;
		}
		if(node.data == num) {
			check = true;
		}
		TreeNode right = inOrderSuccessorWay1(node.right, num);
		if(right != null) return right;
		return null;
	}
	
	
}
