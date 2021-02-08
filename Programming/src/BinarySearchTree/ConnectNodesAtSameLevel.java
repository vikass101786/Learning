package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;


		    /*     	    1
		     *    	  /   \
		     *   	 /     \
		     *  	2       3
		     * 	   / \     / \
		     *    /   \   /   \
		     *   4     5 6     7
		     * 
		     *          1
		     *    	  /   \
		     *   	 /     \
		     *  	2-------3
		     * 	   / \     / \
		     *    /   \   /   \
		     *   4-----5 6-----7
		     * 
		     * */

public class ConnectNodesAtSameLevel {
	
	static int arr [];
	
	static class TreeNode {
		TreeNode left, right,next;
		int data;
		public TreeNode(int data) {
			this.data = data; 
		}
	}
	 
	public static void main(String[] args) {
		
	}
	
	public TreeNode createTree() {
		Queue<TreeNode> queue = new LinkedList<ConnectNodesAtSameLevel.TreeNode>();
		int i = 0;
		TreeNode node = new TreeNode(arr[i]);
		i++;
		queue.add(node);
		while(i<arr.length) {
			
			TreeNode temp = queue.poll();
			temp.left = new TreeNode(arr[i]);
			queue.add(temp.left);
			i++;
			if(i >= arr.length) {
				break;
			}
			
			temp.right = new TreeNode(arr[i]);
			queue.add(temp.right);
			i++;
			if(i >= arr.length) {
				break;
			}
			
		}
		return node;
	}
	
	public TreeNode connectNodesAtSmeLevel(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<ConnectNodesAtSameLevel.TreeNode>();
		queue.add(node);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp == null) {
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			} else {
				if(temp.left != null) {
					queue.add(temp.left);
				}
				
				if(temp.right != null) {
					queue.add(temp.right);
				}
				
				temp.next = queue.peek();
			}
		}
		
		return node;
	}
	
}
