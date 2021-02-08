package BinarySearchTree;

import java.util.Scanner;

public class Solution1 {
	static Scanner sc;
	static TreeNode node;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int num = sc.nextInt();
		int actualNum = sc.nextInt();
		int rajeshNode = sc.nextInt();
		TreeNode head = createTree();
		TreeNode node = find(rajeshNode, head);
		System.out.println(bigBangTreeColoring(node, actualNum));

	}

	public static TreeNode createTree() {
		TreeNode root = null;
		while (sc.hasNext()) {
			int value = sc.nextInt();
			if (value == -1) {
				return null;
			}
			TreeNode node = new TreeNode(value);
			node.left = createTree();
			node.right = createTree();
			return node;
		}
		root = node;
		return node;
	}

	static int bigBangTreeColoring(TreeNode head, int totalNode) {
		int left = 0;
		int right = 0;
		if(head.left != null) {
		left = countNode(head.left);
		}
		if(head.right != null) {
		right = countNode(head.right);
		}

		return left > (totalNode - left) ? 1
				: (right > (totalNode - right) ? 1 : (left + right + 1 < (totalNode - (left + right + 1)) ? 1 : 0));
	}

	static int countNode(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftNum = countNode(node.left);
		int rightNum = countNode(node.right);
		return leftNum + rightNum + 1;
	}

	static TreeNode find(int rajeshNode, TreeNode head) {
		if (head == null) {
			return null;
		}
		if (head.data == rajeshNode) {
			return head;
		}

		TreeNode left = find(rajeshNode, head.left);
		TreeNode right = find(rajeshNode, head.right);
		return  left != null ? left : (right !=null ? right : null);
	}

	static class TreeNode {

		TreeNode left;
		TreeNode right;
		int data;

		TreeNode(int data) {
			this.data = data;
		}

	}

}
