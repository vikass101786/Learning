package Array;

import java.util.*;
public class Main12 {
	static int index ;
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int inOrderArr [] = new int [num];
        int postOrderArr [] =new int [num];
        index = num-1;
        for (int i = 0 ; i < num ; i++) {
            inOrderArr [i] = sc.nextInt();
        }
        for (int i = 0 ; i < num; i++) {
            postOrderArr [i] = sc.nextInt();
        }

        TreeNode head = createTreeFromInOderAndPostOrder(inOrderArr,postOrderArr,0,num-1);
        preOrderTraversal(head);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        TreeNode(int data) {
            this.data=data;
        }
    }

    static void preOrderTraversal(TreeNode head) {
        if(head == null)
            return;
        System.out.print(head.data + " ");
        preOrderTraversal(head.left);
        preOrderTraversal(head.right);
    }

	static TreeNode createTreeFromInOderAndPostOrder(int[] inOrderArr, int[] postOrderArr, int start, int end) {
		
		if (start > end) {
			return null;
		}

			TreeNode head = new TreeNode(postOrderArr[index--]);

			int k = -1;

			if (start == end) {
				return head;
			}

			for (int i = start; i <= end; i++) {
				if (head.data == inOrderArr[i]) {
					k = i;
					break;
				}
			}
			head.right = createTreeFromInOderAndPostOrder(inOrderArr, postOrderArr, k + 1, end);
			head.left = createTreeFromInOderAndPostOrder(inOrderArr, postOrderArr, start, k - 1);
			return head;
	}

}
