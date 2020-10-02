package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SpecialTree {

	static class TreeNode {

		TreeNode left;
		TreeNode right;
		int data;

		public TreeNode(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int arr[] = new int[length];

		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}

		TreeNode specialTreeNode = createSpecialTree(arr, 0, arr.length);
		inOrderTraversal(specialTreeNode);
		System.out.println();
		levelOrderTraversal(specialTreeNode);
	}

	public static void levelOrderTraversal(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		queue.add(null);
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();

			if (tempNode != null) {

				System.out.print(tempNode.data + " ");

				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}

				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			} else {
				if (!queue.isEmpty()) {
					System.out.println();
					queue.add(null);
				}
			}
		}
	}

	static void inOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		inOrderTraversal(node.left);
		System.out.print(node.data + " -> ");
		inOrderTraversal(node.right);
	}

	private static TreeNode createSpecialTree(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (start >= end) {
			return null;
		}

		int max = start;

		for (int i = start + 1; i < end; i++) {
			if (arr[max] < arr[i]) {
				max = i;
			}
		}

		TreeNode node = new TreeNode(arr[max]);
		node.left = createSpecialTree(arr, start, max);
		node.right = createSpecialTree(arr, max + 1, end);
		return node;
	}
}
