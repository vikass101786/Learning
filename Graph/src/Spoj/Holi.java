package Spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Holi {

	//https://www.spoj.com/problems/HOLI/
	
	static Map<Integer, List<Pair>> map;
	static int count[];
	static int value;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		WeightedGraph graph;
		for (int test_no = 0; test_no <= test_cases; test_no++) {
			int total_houses = sc.nextInt();
			map = new HashMap<Integer, List<Pair>>();
			graph = new WeightedGraph(map);
			count = new int[total_houses + 1];
			value = 0;
			Arrays.fill(count, 1);
			for (int house = 0; house < total_houses - 1; house++) {
				int U = sc.nextInt();
				int V = sc.nextInt();
				int weight = sc.nextInt();
				graph.addEdge(U, V, weight);
			}
			dfs(total_houses);
			System.out.println();
		}
	}

	private static void dfs(int total_house) {

		Map<Integer, Boolean> isVisisted = new HashMap<Integer, Boolean>();
		dfsHelper(1, isVisisted, total_house);
		System.out.println(value);
	}

	private static int dfsHelper(Integer current_node, Map<Integer, Boolean> isVisisted, int total_house) {
		// TODO Auto-generated method stub
		isVisisted.put(current_node, true);
		count[current_node] = 1;
		for (Pair neighbour : map.get(current_node)) {
			Integer node = neighbour.nodeKey;
			if (isVisisted.get(node) == null) {
				isVisisted.put(node, true);
				count[current_node] += dfsHelper(node, isVisisted, total_house);
				value += 2 * Math.min(count[node], total_house - count[node]) * neighbour.nodeValue;
			}
		}
		return count[current_node];
	}

	static class WeightedGraph {

		Map<Integer, List<Pair>> map;

		public WeightedGraph(Map<Integer, List<Pair>> map) {
			this.map = map;
		}

		public void addEdge(Integer U, Integer V, Integer weight) {

			Pair pair_1 = new Pair(V, weight);
			if (map.containsKey(U)) {
				map.get(U).add(pair_1);
			} else {
				List<Pair> list = new ArrayList<Pair>();
				list.add(pair_1);
				map.put(U, list);
			}

			Pair pair_2 = new Pair(U, weight);

			if (map.containsKey(V)) {
				map.get(V).add(pair_2);
			} else {
				List<Pair> list = new ArrayList<Pair>();
				list.add(pair_2);
				map.put(V, list);
			}
		}

	}

	static class Pair {
		int nodeKey;
		int nodeValue;

		Pair(int nodeKey, int nodeValue) {
			this.nodeKey = nodeKey;
			this.nodeValue = nodeValue;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[ node_key ] :: " + nodeKey + " , [node_value] :: " + nodeValue;
		}
	}
}
