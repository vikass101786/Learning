package BinarySearchTree;


import java.util.LinkedList;
import java.util.*;
import java.util.Scanner;
import java.io.*;


class TreeNode1
{
    long value;
    TreeNode1 left, right;

    public TreeNode1(long item)
    {
        value = item;
        left = right = null;
    }
}


class BinTree {
	TreeNode1 root;

	BinTree() {
        root = null;
    }

    TreeNode1 createNode(long value) {
    	TreeNode1 t = new TreeNode1(value);
        return t;
    }

    TreeNode1 replaceNegativeOne(TreeNode1 root) {
        if (root == null || (root.value == -1 && root.left == null && root.right == null)) {
            return null;
        }
        root.left = replaceNegativeOne(root.left);
        root.right = replaceNegativeOne(root.right);
        return root;
    }

    TreeNode1 createTreeByLevelTree() {
        Scanner sc = new Scanner(System.in);
        long n, m;
        Queue<TreeNode1> queue = new LinkedList<>();
        TreeNode1 t;
        root = null;
        while (sc.hasNext()) {
            n = sc.nextLong();
            if (queue.isEmpty()) {
                root = createNode(n);
                ((LinkedList<TreeNode1>) queue).add(root);
                continue;
            }
            m = sc.nextLong();
            t = ((LinkedList<TreeNode1>) queue).peekFirst();
            ((LinkedList<TreeNode1>) queue).pop();
            t.left = createNode(n);
            t.right = createNode(m);
            if (t.left.value != -1)
                ((LinkedList<TreeNode1>) queue).add(t.left);
            if (t.right.value != -1)
                ((LinkedList<TreeNode1>) queue).add(t.right);
            if (queue.isEmpty())
                break;
        }
        return root;
    }

    void deleteTree(TreeNode1 node) {
        node = null;
    }

/* Complete the function checkSumTree given below
For your reference

class Node
{
    long value;
    Node left, right;
    public Node(long item)
    {
        value = item;
        left = right = null;
    }
}
*/
static boolean isLeaf(TreeNode1 node) {
		if(node == null)
			return false;
		
		if(node.left == null && node.right == null)
			return true;
		
		return false;
	}

boolean checkSumTree(TreeNode1 node) {
    //write your code here
		long ls;
		long rs;
		
		if(node == null || isLeaf(node)) {
			return true;
		}
		
		if(checkSumTree(node.left) != false && checkSumTree(node.right) != false) {
			
			if(node.left == null) {
				ls = 0;
			} else if (isLeaf(node.left) != false) {
				ls = node.left.value;
			} else {
				ls = 2 * (node.left.value);
			}
			
			if(node.right == null) {
				rs = 0;
			} else if (isLeaf(node.right) != false) {
				rs = node.right.value;
			} else {
				rs = 2 * (node.right.value);
			}
			
			if(node.value == (ls + rs)) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
}


}
public class CheckSumTree {

    public static void main(String[] args) {
        // write your code here
            BinTree bt = new BinTree();
            bt.root = bt.createTreeByLevelTree();
            bt.root = bt.replaceNegativeOne(bt.root);
            if(bt.checkSumTree(bt.root)==true)
                System.out.println("true");
            else
                System.out.println("false");
            bt.deleteTree(bt.root);
    }
}