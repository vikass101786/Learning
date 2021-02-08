import java.util.Scanner;

import BinarySearchTree.BinaryTree;
import BinarySearchTree.BinaryTree.TreeNode;

public class Practise {
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		Integer arr [] = new Integer [length];
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		TreeNode head = BinaryTree.createTree(arr);
		System.out.println(countNode(head));
	}

	
	public static int countNode(TreeNode head) {
		if(head == null) {
			return 0;
		}
		
		int left = countNode(head.left);
		int right = countNode(head.right);
		return 1+left+right;
	}
	
}
