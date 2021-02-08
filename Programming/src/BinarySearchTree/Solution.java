package BinarySearchTree;

import java.util.*;
public class Solution {
static int ans ;
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0 ; i < testCases; i++) {
        	sc.nextLine();
            String input = sc.nextLine();
            ans = 0;
            String arr [] = input.split(" ");
            int sum = sc.nextInt();
            TreeNode node = createTree(arr);
            String print = "";
            countSubTreeSum(node, sum, print);
            System.out.println(ans);
        }
    }


static class TreeNode {
  
  TreeNode left;
  TreeNode right;
  int data;
  
  TreeNode(int data) {
      this.data=data;
  }
}


private static TreeNode createTree(String [] arr) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    TreeNode head = new TreeNode(Integer.valueOf(arr[0]));
    queue.add(head);
    int size = 1;
    while(size < arr.length) {
        TreeNode currentNode = queue.poll();
        currentNode.left = new TreeNode(Integer.valueOf(arr[size++]));
        queue.add(currentNode.left);
        if(size > arr.length) {
            break;
        }
        currentNode.right = new TreeNode(Integer.valueOf(arr[size++]));
        queue.add(currentNode.right);
        if(size > arr.length) {
            break;
        }
    }
    return head;
}

public static int countSubTreeSum(TreeNode node, int sum, String print) {

    if(node == null) {
        return 0;
    }
    
    if(node.left != null) {
    	print = print + " "+ node.left.data;
    }
    int left = countSubTreeSum(node.left, sum, print );
    if(node.right != null) {
    	print = print + " "+ node.right.data;
    }
    int right = countSubTreeSum(node.right, sum, print);

    if ((left+right+node.data) == sum) {
    	System.out.println(print);
        ans++;
    }

    return node.data+left+right;
 }
}