package AdjacencyList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleDetectionInDirectedGraphUsingDFS<T> {

	Map<T, List<T>> dgMap = new HashMap<T, List<T>>();

	boolean isCycle(T source) {
		Map<T, GraphDetails> map = new HashMap<T, GraphDetails>();
		for (Map.Entry<T, List<T>> iterMap : dgMap.entrySet()) {
			T node = iterMap.getKey();
			boolean cyclePresent = dfsHelper(node, map);
			if (cyclePresent) {
				return true;
			}
		}
		return false;
	}

	private boolean dfsHelper(T source, Map<T, GraphDetails> map) {
		// TODO Auto-generated method stub
		GraphDetails remappingFunction = new GraphDetails();
		remappingFunction.isVisited = true;
		remappingFunction.inStack = true;
		map.put(source, remappingFunction);
		boolean isCyclic = false;
		if (dgMap.get(source) != null)
			for (T neighbour : dgMap.get(source)) {
				if (map.get(neighbour) != null
						&& (map.get(neighbour).isVisited == true && (isCyclic || map.get(neighbour).inStack == true))) {
					return true;
				} else {
					isCyclic = dfsHelper(neighbour, map);
					map.get(neighbour).inStack = false;
				}
			}
		return isCyclic;
	}

	public static void main(String[] args) {
		CycleDetectionInDirectedGraphUsingDFS cdg = new CycleDetectionInDirectedGraphUsingDFS();
		GraphUsingHashMap graph = new GraphUsingHashMap(cdg.dgMap, false);
		graph.addEdge(0, 1);
		graph.addEdge(1, 5);
		graph.addEdge(0, 2);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);

		if (cdg.isCycle(0)) {
			System.out.println("Graph is Cyclic !!");
		} else {
			System.out.println("Graph is not Cyclic !!");
		}

	}

	static class GraphDetails {
		boolean isVisited;
		boolean inStack;

		@Override
		public String toString() {
			return " isVisited :: " + isVisited + ", inStack :: " + inStack;
		}
	}

}
