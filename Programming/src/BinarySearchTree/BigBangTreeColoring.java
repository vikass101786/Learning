package BinarySearchTree;

import java.util.Scanner;

public class BigBangTreeColoring {
	/*
	 * A Binary tree is given . There are 2 players Rajesh Koothrapalli and Howard
	 * Wolowitz . We are given the root of this binary tree, and the number of nodes
	 * n in the tree. n is odd, and each node has a distinct value from 1 to n.
	 * 
	 * Initially, Rajesh(first) colors a value x with 1 <= x <= n, and Howard colors
	 * a value y with 1 <= y <= n and y != x. Rajesh colors the node with value x
	 * red, and Howard colors the node with value y blue.
	 * 
	 * Then, the players take turns starting with Rajesh who is the first player .
	 * In each turn, that player chooses a node of their color (red if player 1,
	 * blue if player 2) and colors an uncolored neighbor of the chosen node (either
	 * the left child, right child, or parent of the chosen node.)
	 * 
	 * If (and only if) a player cannot choose such a node in this way, they must
	 * pass their turn. If both players pass their turn, the game ends, and the
	 * winner is the player that colored more nodes.
	 * 
	 * Howard and Rajesh are best friends . So they are playing this game
	 * strategically .
	 * 
	 * You are Howard. If it is possible to choose such a y to ensure you win the
	 * game, print 1. If it is not possible, print 0.
	 * 
	 * Input Format First line contains 3 integers ( Total Nodes including leaves
	 * which are depicted as -1s , Actual Nodes which are depicted by Natural
	 * numbers 1 to Inf , X is the node with natural number X which is marked by the
	 * First Person ) Second line Contains T_Nodes space separated integers (-1 is a
	 * leaf) in preorder fashion for the tree to be constructed .
	 * 
	 * Note : You have to construct the tree from the preorder sequence given.
	 * 
	 * Constraints 1<=Actual Nodes<=1000 Total Nodes may vary accordingly .
	 * 
	 * Output Format Single digit 0 (LOSE) or 1 (WIN)
	 * 
	 * Sample Input 7 3 1 1 2 -1 -1 3 -1 -1 Sample Output 0 Explanation
	 * 
	 * According to input :- we have 7 total nodes 3 actual nodes and 1 is marked
	 * therefore if the second player tried to mark 2 or 3 . He/She loses in any
	 * case so 0 is the output . -1s are leaves for Node with 2 and Node with 3.
	 * 
	 * [1] // COLORED NODE IN BRACES / \ 2 3
	 * 
	 * 
	 * 11 5 3
	 * 
	 * 1 2 4 -1 -1 5 -1 -1 3 -1 -1
	 * 
	 * 143 71 71
	 * 
	 * 
	 * 51 41 71
	 * 
	 * 14 52 25 46 -1 -1 -1 -1 40 6 53 65 -1 -1 -1 -1 62 -1 30 -1 5 28 -1
	 * -1 -1 4 45 31 1 -1 -1 9 58 38 -1 -1 -1 47 -1 -1 8 55 59 -1 -1 -1 48 -1 -1 3
	 * 37 68 22 -1 -1 64 44 -1 -1 29 -1 -1 49 69 67 -1 -1 -1 63 39 32 -1 -1 50 -1 -1
	 * 17 -1 -1 42 -1 -1 27 23 16 43 11 18 -1 -1 21 -1 -1 -1 10 -1 54 -1 -1 -1 12 70
	 * 36 -1 -1 2 57 -1 -1 56 20 66 -1 -1 -1 26 35 61 -1 15 -1 -1 -1 24 -1 -1 -1 13
	 * 33 34 60 -1 -1 -1 7 19 -1 -1 -1 -1
	 * 
	 * 11 5 2
	 * 
	 * 1 2 4 -1 -1 5 -1 -1 3 -1 -1
	 * 
	 * 
	 * 23 11 3
	 * 
	 * 1 2 4 8 -1 -1 9 -1 -1 5 10 -1 -1 11 -1 -1 3 6 -1 -1 7 -1 -1
	 */
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
		if (head.left != null) {
			left = countNode(head.left);
		}
		if (head.right != null) {
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
		return left != null ? left : (right != null ? right : null);
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
