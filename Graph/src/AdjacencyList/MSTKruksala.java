package AdjacencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MSTKruksala {
	
	static Map<Integer, Pair> map = new TreeMap<Integer, Pair>();
	static Map<Integer, List<NodePair>> graphMap = new TreeMap<Integer, List<NodePair>>();
	
	static void findMST() {
		Map<Integer, Boolean> isVisited = new HashMap<Integer, Boolean>();
		WeightedGraph graph = new WeightedGraph(graphMap);
		for (Map.Entry<Integer, Pair> iterMap : map.entrySet()) {
			int U = iterMap.getValue().U;
			int V = iterMap.getValue().V;
			if(isVisited.get(U) == null ||isVisited.get(V) == null) {
				graph.addEdge(U, V, iterMap.getKey());
				isVisited.put(U, true);
				isVisited.put(V, true);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		for(int i = 0 ; i < test_cases ; i++) {
			int  U = sc.nextInt();
			int V = sc.nextInt();
			int weight = sc.nextInt();
			map.put(weight, new Pair(U, V));
		}
		findMST();
	}
	
	
	static class Pair {
		int U;
		int V;
		public Pair(int U, int V) {
			// TODO Auto-generated constructor stub
			this.U = U;
			this.V = V;
		}
	}
	
	static class WeightedGraph {

		Map<Integer, List<NodePair>> map;

		public WeightedGraph(Map<Integer, List<NodePair>> map) {
			this.map = map;
		}

		public void addEdge(Integer U, Integer V, Integer weight) {

			NodePair pair_1 = new NodePair(V, weight);
			if (map.containsKey(U)) {
				map.get(U).add(pair_1);
			} else {
				List<NodePair> list = new ArrayList<NodePair>();
				list.add(pair_1);
				map.put(U, list);
			}

			NodePair pair_2 = new NodePair(U, weight);

			if (map.containsKey(V)) {
				map.get(V).add(pair_2);
			} else {
				List<NodePair> list = new ArrayList<NodePair>();
				list.add(pair_2);
				map.put(V, list);
			}
		}

	}

	static class NodePair {
		int nodeKey;
		int nodeValue;

		NodePair(int nodeKey, int nodeValue) {
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
