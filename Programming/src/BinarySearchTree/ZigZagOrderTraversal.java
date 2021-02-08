package BinarySearchTree;

import java.util.*;

public class ZigZagOrderTraversal {

	
	/*
	 * 10 true 20 true 40 false false true 50 false false true 30 true 60 false
	 * false true 73 false false
	 * 
	 * 10 30 20 40 50 60 73
	 */
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		ZigZagOrderTraversal m = new ZigZagOrderTraversal();
		BinaryTree bt = m.new BinaryTree();
		bt.levelOrderZZ();
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public void levelOrderZZ() {

			// write your code here
			List<Integer> list = new LinkedList<>();
			List<List<Integer>> ans = new LinkedList<>();
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(null);
			int level = 0;
			while (!queue.isEmpty()) {
				Node temp = queue.poll();
				if (temp == null) {

					if (level % 2 == 0) {
						for (int i = 0; i < list.size(); i++) {
							System.out.print(list.get(i) + " ");
						}
						
					} else {
						Collections.reverse(list);
						for (int i = 0; i < list.size(); i++) {
							System.out.print(list.get(i) + " ");
						}
					}

					level++;

					if (!queue.isEmpty()) {
						queue.add(null);
					}

					list = new LinkedList<>();

				} else {
					
					list.add(temp.data);
					
					if (temp.left != null) {
						queue.add(temp.left);
					}
					if (temp.right != null) {
						queue.add(temp.right);
					}
				}
			}

		}

	}

}
