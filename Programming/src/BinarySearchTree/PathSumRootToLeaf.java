package BinarySearchTree;

import java.util.Scanner;

public class PathSumRootToLeaf {

	static Scanner sc ;

    public static void main (String args[]) {
		sc = new Scanner(System.in);
		TreeNode node = createTree();
		int currentSum = 0;
		int sum = sc.nextInt();
		if (isPathToSum(node, sum, currentSum) != null) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
    }

	static class TreeNode {

		TreeNode left;
		TreeNode right;
		int data;

		TreeNode(int data)
		{
			this.data=data;
		}
	}

	static Boolean isPathToSum(TreeNode node, int sum, int currentSum) {
		if(node == null) {
			return null;
		}
		if(currentSum == sum) {
			//System.out.println(currentSum);
			return true;
		}

		Boolean left = isPathToSum(node.left, sum, currentSum+node.data);
		Boolean right = isPathToSum(node.right, sum, currentSum+node.data);

		return left != null ? left : right;
	}


	static TreeNode createTree() {
		TreeNode head = null;
		if(sc.hasNext()) {
			int value = sc.nextInt();
			TreeNode node = new TreeNode(value);
			boolean isLeft = sc.hasNextBoolean();
			if(isLeft && sc.nextBoolean()) {
				node.left = createTree();
			}
			boolean isRight = sc.hasNextBoolean();
			if(isRight && sc.nextBoolean()) {
				node.right = createTree();
			}
			head = node;
		}
		return head;
	}

}