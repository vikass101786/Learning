package com.ds.BinaryTree;

public class BInaryTreeImpl {

	Node root;

	BInaryTreeImpl() {
		root = null;
	}

	public Node addEle(Node root, int data) {

		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (root.data <= data) {
			root.right = addEle(root.right, data);
		} else {
			root.left = addEle(root.left, data);
		}

		return root;
	}

	void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}

	public Node lca(Node root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.data == n1 || root.data == n2)
			return root;
		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);
		if (left != null && right != null)
			return root;
		if (left == null && right == null)
			return null;

		return left != null ? left : right;
	}

	public static void main(String[] args) {

		int[] arr = { 4, 5, 2, 7, 1, 8, 6, 9, 3, 11 };
		BInaryTreeImpl bt = new BInaryTreeImpl();
		for (int i = 0; i < arr.length; i++) {
			bt.root = bt.addEle(bt.root, arr[i]);
		}
		bt.inOrder(bt.root);
		System.out.println("=====================");
		System.out.println(bt.lca(bt.root, 3, 5).data);
	}
}
