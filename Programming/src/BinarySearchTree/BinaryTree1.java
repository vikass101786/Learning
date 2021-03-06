package BinarySearchTree;

//Java Program for above approach
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Node {
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

public class BinaryTree1 {

	Node root;

	// Values class
	class Values {
		int max, min;
	}

	// Program to find vertical Order
	public void verticalOrder(Node node)
	{
		Values val = new Values();

		// Create TreeMap
		Map<Integer, List<Integer> > map
			= new TreeMap<Integer, List<Integer> >();

		// Function Call to findHorizonatalDistance
		findHorizonatalDistance(node, val, val, 0, map);

		// Iterate over map.values()
		for (List<Integer> list : map.values()) {
			System.out.println(list);
		}

		// Print "done"
		System.out.println("done");
	}

	// Program to find Horizonatal Distance
	public void findHorizonatalDistance(
		Node node, Values min, Values max, int hd,
		Map<Integer, List<Integer> > map)
	{

		// If node is null
		if (node == null)
			return;

		// if hd is less than min.min
		if (hd < min.min)
			min.min = hd;

		// if hd is greater than min.min
		if (hd > max.max)
			max.max = hd;

		// Using computeIfAbsent
		map.computeIfAbsent(hd,
							k -> new ArrayList<Integer>())
			.add(node.data);

		// Function Call with hd equal to hd - 1
		findHorizonatalDistance(node.left, min, max, hd - 1,
								map);

		// Function Call with hd equal to hd + 1
		findHorizonatalDistance(node.right, min, max,
								hd + 1, map);
	}

	// Driver Code
	public static void main(String[] args)
	{

		BinaryTree1 tree = new BinaryTree1();

		/* Let us construct the tree shown
							in above diagram */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		System.out.println("vertical order traversal is :");

		// Function Call
		tree.verticalOrder(tree.root);
	}
}

