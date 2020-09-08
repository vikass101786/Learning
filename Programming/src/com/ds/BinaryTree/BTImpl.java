package com.ds.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Math;

public class BTImpl {

	static Scanner sc = new Scanner(System.in);

	static float levelSum = 0;
	static float levelCount = 0;
	static List<Integer> path1 = new LinkedList<Integer>();
	static List<Integer> path2 = new LinkedList<Integer>();
	
	Node head;

	public static Node addNode() {
		int value = sc.nextInt();
		if (value == -1)
			return null;

		Node newNode = new Node(value);
		newNode.left = addNode();
		newNode.right = addNode();
		return newNode;
	}

	static void print(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " -> ");
		print(root.left);
		print(root.right);
	}

	static int height(Node root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		Node printNode = addNode();
		//Node copyOfNode = printNode;
		for(int i = 1 ; i <= height(printNode); i++) {
			printKthLevel(printNode, i);
			System.out.println();
			//System.out.println(levelSum/levelCount);
		}
		
		/*
		 * Node anotherPrintNode = mirror(copyOfNode);
		 * 
		 * for(int i = 1 ; i <= height(anotherPrintNode); i++) {
		 * printKthLevel(printNode, i); System.out.println();
		 * //System.out.println(levelSum/levelCount); }
		 */
		

		
		print(printNode);
		System.out.println();
		System.out.println(height(printNode));
		System.out.println();
		System.out.println(" ================ IN ORDER TRAVERSAL ============ ");
		System.out.println();
		inOrderPrint(printNode);
		System.out.println();
		System.out.println(" ================ POST ORDER TRAVERSAL ============ ");
		System.out.println();
		postOrderTraversal(printNode);
		System.out.println();
		System.out.println(" ================ PRE ORDER TRAVERSAL ============ ");
		System.out.println();
		preOrderTraversal(printNode);
		System.out.println();
		System.out.println(" ================ LEVEL ORDER TRAVERSAL ============ ");
		for(int i = 1 ; i <= height(printNode); i++) {
			printKthLevel(printNode, i);
			System.out.println();
			//System.out.println(levelSum/levelCount);
		}
		
		/*
		 * for(int i = 1 ; i <= height(anotherPrintNode); i++) {
		 * printKthLevel(printNode, i); System.out.println();
		 * //System.out.println(levelSum/levelCount); }
		 */
		
		System.out.println();
		isSumTree(printNode);
		
		path1.clear(); path2.clear();
		System.out.println(" =========== Find LCA =========== ");
		System.out.println(findLCA(5, 7, printNode));
		System.out.println(" =========== Check Mirror ======== ");
		//System.out.println(checkMirrorTree(printNode, anotherPrintNode));
		System.out.println(distinctPath(printNode));
		System.out.println(" ================ Total Turns =============== ");
		System.out.println(findMaxTurns(printNode));
	}

	static void inOrderPrint(Node root) {
		if (root == null)
			return;
		inOrderPrint(root.left);
		System.out.print(root.data + " -> ");
		inOrderPrint(root.right);
	}

	static void postOrderTraversal(Node root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	static void preOrderTraversal(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	static void printKthLevel(Node root, int K) {

		if (root == null)
			return;

		if (K == 1) {
			System.out.print(root.data + " ");
			levelSum += root.data;
			levelCount++;
		 }

		printKthLevel(root.left, K - 1);
		printKthLevel(root.right, K - 1);

		return;
	}
	
	
	static boolean isLeaf(Node node) {
		if(node == null)
			return false;
		
		if(node.left == null && node.right == null)
			return true;
		
		return false;
	}
	
	 static boolean isSumTree(Node node) {
		
		int ls;
		int rs;
		
		if(node == null || isLeaf(node)) {
			return true;
		}
		
		if(isSumTree(node.left) != false && isSumTree(node.right) != false) {
			
			if(node.left == null) {
				ls = 0;
			} else if (isLeaf(node.left) != false) {
				ls = node.left.data;
			} else {
				ls = 2 * (node.left.data);
			}
			
			if(node.right == null) {
				rs = 0;
			} else if (isLeaf(node.right) != false) {
				rs = node.right.data;
			} else {
				rs = 2 * (node.right.data);
			}
			
			if(node.data == (ls + rs)) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	 
	 static int findLCA(int n1 , int n2 , Node root) {
		 
		 if(!findPath(root,n1,path1) || !findPath(root,n2,path2)) {
			 return -1;
		 }
		 int i = 0;
		 for( ; path1.size() > i && path2.size() > i ; i++) {
			 if(!path1.get(i).equals(path2.get(i))) {
				 break;
			 }
		 }
		 
		 return path1.get(i-1);
	 }

	private static boolean findPath(Node root, int n, List<Integer> path) {
		// TODO Auto-generated method stub
		if(root == null) {
			return false;
		}
		
		path.add(root.data);
		
		if(root.data == n) {
			return true;
		}
		
		if(root.left != null && findPath(root.left, n, path)) {
			return true;
		}
		
		if(root.right != null && findPath(root.right, n, path)) {
			return true;
		}
		
		path.remove(path.size()-1);
		
		return false;
	}
	
	static List<Integer> mr1 = new LinkedList<Integer>();
	static List<Integer> mr2 = new LinkedList<Integer>();

	static boolean checkMirrorTree(Node node1, Node node2) {
	    //write your code here   
	    mr1.clear();
	    mr2.clear();
	    
	    inOrder(node1, mr1);
	    inOrder(node2, mr2);
	    
	    int i = 0 , j = mr2.size()-1;
	    for (  ; i < mr1.size() && j > 0 ; ) {
	      if(mr1.get(i) != mr2.get(j)){
	        return false;
	      }
	      i++;
	      j--;
	    }
	    return true;
	}

	static void inOrder(Node node , List<Integer> mirror) {
	  if(node == null) {
	    return;
	  }
	  
	  inOrder(node.left,mirror);
	  mirror.add(node.data);
	  inOrder(node.right,mirror);
	}
	
	static Node mirror(Node root) {
		if(root == null) {
			return root;
		}
		
		Node left = mirror(root.left);
		Node right = mirror(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}

	
	 static int distinctPath(Node root) {
		 if(root == null) {
			return 0; 
		 }
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		 return calDistinctPath(root,map);
	 }

	private static int calDistinctPath(Node root, Map<Integer, Integer> hMap) {
		// TODO Auto-generated method stub
		if(root == null) {
			return hMap.size();
		}
		
		int currentKey = root.data;
		
		if(hMap.containsKey(currentKey)) {
			hMap.put(currentKey, hMap.get(currentKey) + 1);
		} else {
			hMap.put(currentKey,  1);
		}
		
		int totalPath = Math.max(calDistinctPath(root.left, hMap), calDistinctPath(root.right, hMap));
		
		if(hMap.containsKey(root.data)) {
			hMap.replace(root.data, hMap.get(root.data) -1);
		}
		
		if(hMap.get(root.data) == 0) {
			hMap.remove(root.data);
		}
		
		return totalPath;
	}
	
	public static int turn(Node root) {
		return Math.max(totalTurn(root.left,0,false) , totalTurn(root.right,0,true));
	}

	private static int totalTurn(Node root, int turns, boolean it_was_right) {
		// TODO Auto-generated method stub
		if(root == null) {
			return 0;
		}
		
		return turns += Math.max(totalTurn(root.left, 0, !it_was_right) , totalTurn(root.right, 1, it_was_right));
	}

	int findTurnCount(Node T) {
	    //write your code here
	    int max = 0, turns = 0;
	        Stack<Node> stack = new Stack<Node>();
	        boolean last_was_left = true;
	        boolean going_right = false;
	        while(true)
	        {
	            if (T != null)
	            {
	                if (!(last_was_left ^ going_right))
	                    turns++;

	                stack.push(T);
	                last_was_left = !going_right;
	                going_right = false;
	                T = T.left;
	            }
	            else if (stack.size() > 0)
	            {
	                if (stack.size() == 1) // left branch completed, switch to right branch & reset turns
	                {
	                    last_was_left = false;
	                    max = Math.max(max, turns);
	                    turns = 0;
	                }
	                T = stack.pop();
	                going_right = true;
	                T = T.right;
	            }
	            else // completed both branches
	                break;
	        }

	        return Math.max(max, turns);
	}
	
	static int maxBends = -1;
	static int len = 0;
	
	static int findMaxTurns(Node root) {
		if(root == null) {
			return 0;
		}
		int bends =0;
		
		if(root.left != null) {
			findMaxTurnsUtil(root.left,'l',bends,maxBends,1,len);
		}
		
		if(root.right != null) {
			len =	findMaxTurnsUtil(root.right,'r',bends,maxBends,1,len);
		}
		len++;
		return len;
	}

	private static int findMaxTurnsUtil(Node node, char dir, int bends, int maxBends, int soFar, int len) {
		// TODO Auto-generated method stub
		if(node == null) {
			return bends;
		}
		
		if (node.left == null && node.right == null) {
			if(bends > maxBends) {
				maxBends = bends;
				len = soFar;
			}
		}
		else {
			if(dir == 'l') {
				bends = Math.max(findMaxTurnsUtil(node.left, dir, bends, maxBends, soFar+1, len), findMaxTurnsUtil(node.right, 'r', bends+1, maxBends, soFar+1, len)); 
				
			} else {
				bends += Math.max(findMaxTurnsUtil(node.right, dir, bends, maxBends, soFar+1, len), findMaxTurnsUtil(node.left, 'l', bends+1, maxBends, soFar+1, len));
			}
		}
		return bends;
	}

}
