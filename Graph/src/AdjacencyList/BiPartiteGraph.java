package AdjacencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BiPartiteGraph {
	
	

	/*
	 * 5 
	 * 1 2
	 *  2 3
	 *   3 4
	 *    4 2 
	 *    1 4
	 * 
	 * Answer = > FALSE
	 * 
	 * 4
	 *  1 2
	 *   2 3
	 *    3 4
	 *     4 1
	 * 
	 * Answer = > TRUE
	 */
	
	static String colourArr [] =  {"Green","Blue"};
	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	
	
	static boolean isBiPartiteGraph(int source) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		Map<Integer, String> colour = new HashMap<Integer, String>();
		Map<Integer, Boolean> isVisited = new HashMap<Integer, Boolean>();
		isVisited.put(source, true);
		colour.put(source, colourArr[0]);
		while(!queue.isEmpty()) {
			Integer current_node = queue.poll();
			for (Integer neighbour : map.get(current_node)) {
				if (isVisited.get(neighbour) == null) {
					queue.add(neighbour);
					isVisited.put(neighbour, true);
					String colour_of_node = colour.get(current_node) == colourArr[0] ? colourArr[1] : colourArr[0];
					colour.put(neighbour, colour_of_node);
				} else if (colour.get(neighbour) == colour.get(current_node)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		Graph graph = new Graph(map);
		int source = -1;
		for (int i = 0 ; i < number ; i++) {
			int U = sc.nextInt();
			int V = sc.nextInt();
			if(source < 0) {
				source = U;
			}
			graph.addEdge(U, V);
		}
		if(isBiPartiteGraph(source)) {
			System.out.println("Graph is BiPartite");
		} else {
			System.out.println(" NOPE !!!!");
		}
	}
	
	static class Graph {
		Map<Integer, List<Integer>> map;
		Boolean bidirectional;
		
		public Graph(Map<Integer, List<Integer>> map) {
			this.map = map;
			this.bidirectional = true;
		}

		void addEdge(Integer U, Integer V) {
			if (map.containsKey(U)) {
				map.get(U).add(V);
			} else {
				List<Integer> li = new ArrayList<Integer>();
				li.add(V);
				map.put(U, li);
			}

			if (bidirectional) {
				if (map.containsKey(V)) {
					map.get(V).add(U);
				} else {
					List<Integer> li = new ArrayList<Integer>();
					li.add(U);
					map.put(V, li);
				}
			}
		}
	}

}
