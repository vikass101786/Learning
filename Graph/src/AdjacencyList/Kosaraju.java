package AdjacencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Kosaraju {

	// Connected Graph
	
	/*
	 * 6 1 2 false 2 3 false 3 4 false 4 5 false 5 1 false 5 6 true
	 */
	 

	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	static Map<Integer, List<Integer>> revMap = new HashMap<Integer, List<Integer>>();

	static boolean isConnectedGraph(int source) {
		Map<Integer, Boolean> isVisited = new HashMap<Integer, Boolean>();
		return dfsHelper(source, isVisited, map) && clearMap(isVisited) && dfsHelper(source, isVisited, revMap);
	}

	static boolean clearMap(Map<Integer, Boolean> isVisited) {
		isVisited.clear();
		return isVisited.size() == 0;
	}

	private static boolean dfsHelper(int source, Map<Integer, Boolean> isVisited, Map<Integer, List<Integer>> map2) {
		// TODO Auto-generated method stub
		isVisited.put(source, true);

		if (map2.get(source) != null) {
			for (Integer neighbour : map2.get(source)) {
				if (isVisited.get(neighbour) == null) {
					dfsHelper(neighbour, isVisited, map2);
				}
			}
		}
		return isVisited.size() == map2.size();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		Graph graph = new Graph(map);
		Graph graph1 = new Graph(revMap);
		Integer source = -1;
		for (int i = 0; i < number; i++) {
			int U = sc.nextInt();
			int V = sc.nextInt();
			if (source < 0) {
				source = U;
			}
			Boolean bidirectional = sc.nextBoolean();
			graph.addEdge(U, V, bidirectional);
			graph1.addEdge(V, U, bidirectional);
		}

		if(isConnectedGraph(source)) {
			System.out.println(" It's a connected Graph");
		} else {
			System.out.println(" Not a connected Graph");
		}
	}

	static class Graph {
		Map<Integer, List<Integer>> map;

		public Graph(Map<Integer, List<Integer>> map) {
			this.map = map;
		}

		void addEdge(Integer U, Integer V, Boolean bidirectional) {
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
