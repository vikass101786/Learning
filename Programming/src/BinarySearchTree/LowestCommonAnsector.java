package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class LowestCommonAnsector {
		
	public static class TreeNode {
		TreeNode left , right;
		int data;
		
		public TreeNode(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			left = right = null;
		}
	}
	
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
			arr[i] = sc.nextInt();
		}
		
		TreeNode node = createTree(arr);
		System.out.println("\n");
		System.out.println(findLCA(node, 8, 15));
	
	}
	
	public static Integer findLCA(TreeNode root , int node1 , int node2) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		 arr1 = eleTillNode(root , node1 , arr1 );
		 arr2 = eleTillNode(root , node2 , arr2);
		 
		 int i = 0; 
		 for (; i < arr1.size() && i < arr2.size() ; i++) {
			 if(arr1.get(i) != arr2.get(i)) {
				 break;
			 }
		 }
		 
		 return arr1.get(i-1);
	}

	private static ArrayList<Integer> eleTillNode(TreeNode root, int node , ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		if(root == null) {
			return arr; 
		}
		
		if(root.data == node) {
			 arr.add(root.data);
			 return arr;
		}
		
		arr.add(root.data);
		eleTillNode(root.left, node, arr);
		eleTillNode(root.right, node, arr);
		arr.remove(arr.size()-1);
		return arr;
	}
	
}
 