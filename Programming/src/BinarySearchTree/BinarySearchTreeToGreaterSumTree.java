package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*  Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.

Input Format
Level order input for the binary search tree will be given.

Constraints
None

Output Format
display tree after modification

Sample Input
5 1 7 0 2 6  8 -1 -1 -1 3 -1 -1 -1 9 -1 -1 -1 -1
Sample Output
41<--35-->24
41<--41-->40
.<--41-->.
.<--40-->38
.<--38-->.
30<--24-->17
.<--30-->.
.<--17-->9
.<--9-->.*/
  
  

public class BinarySearchTreeToGreaterSumTree {
	static Scanner sc = new Scanner(System.in);
	static int sum = 0;

	public static void main(String[] args) {
		TreeNode head = createTreeUsingLevelOrder();
		bstToGreaterSumTree(head);
		display(head);
	}

	private static void display(TreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}
		str += "<--";
		str += node.data + "-->";
		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	private static void bstToGreaterSumTree(TreeNode node) {
		if (node == null)
			return;
		bstToGreaterSumTree(node.right);
		sum += node.data;
		node.data = sum;
		bstToGreaterSumTree(node.left);

	}

	static class TreeNode {
		TreeNode right;
		TreeNode left;
		int data;

		public TreeNode(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}
	}

	public static TreeNode createTreeUsingLevelOrder() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode head = new TreeNode(sc.nextInt());
		queue.add(head);
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			int data = sc.nextInt();
			if (data != -1) {
				tempNode.left = new TreeNode(data);
				queue.add(tempNode.left);
			}
			if (!sc.hasNext()) {
				break;
			}
			data = sc.nextInt();
			if (data != -1) {
				tempNode.right = new TreeNode(data);
				queue.add(tempNode.right);
			}
		}

		return head;
	}

}
