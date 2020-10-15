package HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JourneyToMoon {

	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	static boolean singleNode[];
	int count_of_astronaut_in_group ;

	public void moonDFS() {

		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		int n = map.size();
		long total_ways = (long)n * (n - 1) / 2;
		for (Map.Entry<Integer, List<Integer>> currentNode : map.entrySet()) {
			count_of_astronaut_in_group = 0;
			int neighbour = currentNode.getKey();
			if (visited.get(neighbour) == null) {
				count_of_astronaut_in_group = dfsHelper(neighbour, visited);
				//System.out.println(" count_of_astronaut_in_group " + count_of_astronaut_in_group);
				total_ways -= count_of_astronaut_in_group * (count_of_astronaut_in_group - 1) / 2;
			}
		}
		System.out.println(total_ways);
	}

	private int dfsHelper(Integer neighbour, Map<Integer, Boolean> visited) {
		// TODO Auto-generated method stub
		visited.put(neighbour, true);
		count_of_astronaut_in_group++;
		for (Integer node : map.get(neighbour)) {
			if (visited.get(node) == null) {
				dfsHelper(node, visited);
			}
		}
		return count_of_astronaut_in_group;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int astronaut_num = sc.nextInt();
		JourneyToMoon journeyToMoon = new JourneyToMoon();
		int total_group = sc.nextInt();
		Graph graph = new Graph(map);
		singleNode = new boolean[astronaut_num];
		for (int i = 0; i < total_group; i++) {
			int U = sc.nextInt();
			singleNode[U] = true;
			int V = sc.nextInt();
			singleNode[V] = true;
			graph.addEdge(U, V);
		}

		for (int k = 0; k < astronaut_num; k++) {
			if (!singleNode[k]) {
				graph.addEdge(k, -1);
			}
		}

		journeyToMoon.moonDFS();
	}

	static class Graph {
		Map<Integer, List<Integer>> map;

		public Graph(Map<Integer, List<Integer>> map) {
			this.map = map;
		}

		public void addEdge(int U, int V) {
			if (map != null) {
				if (!map.containsKey(U)) {
					List<Integer> list = new ArrayList<Integer>();
					if (V >= 0) {
						list.add(V);
					}
					map.put(U, list);
				} else {
					if (V >= 0) {
						map.get(U).add(V);
					}
				}

				if (V >= 0) {
					if (!map.containsKey(V)) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(U);
						map.put(V, list);
					} else {
						map.get(V).add(U);
					}
				}
			}
		}

	}

}
