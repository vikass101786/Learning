package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import BinarySearchTree.MirrorTree.TreeNode;

public class Path_Sum {
	
	private static TreeNode createTree(int[] arr) {
		// TODO Auto-generated method stub
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode node = new TreeNode(arr[0]);
		queue.add(node);
		int i = 1;
		
		while(i < arr.length) {
			TreeNode temp = queue.poll();
			
			temp.left = new TreeNode(arr[i++]);
			queue.add(temp.left);
			if(i >= arr.length) {
				break;
			}
			
			temp.right = new TreeNode(arr[i++]);
			queue.add(temp.right);
			if(i >=  arr.length) {
				break;
			}
		}
	return node;	
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int arr [] = new int [number];
		for (int i = 0 ; i < number ; i++) {
			arr [i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		
		TreeNode node = createTree(arr);
		System.out.println(isPathSum(node, 0 , sum , ""));
	}
	
	
	public static boolean isPathSum(TreeNode root , int cuurentSum , int actualSum , String path) {
		if(root == null) return false;
		
		if(root.left == null && root.right == null) {
			if((cuurentSum + root.data) == actualSum) {
				System.out.println(path +" " + root.data);
				return true;
			}
		}
		
		return isPathSum(root.left, cuurentSum + root.data, actualSum, path + " " + root.data) ||
				isPathSum(root.right, cuurentSum + root.data, actualSum, path + " " + root.data);
		
	}
	
	
}
