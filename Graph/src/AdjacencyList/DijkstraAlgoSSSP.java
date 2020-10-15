package AdjacencyList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DijkstraAlgoSSSP<T> {
	
	Map<T, List<GraphWithWeight<Integer>>> dijkMap = new HashMap<T, List<GraphWithWeight<Integer>>>();
	
	
	public static void main(String[] args) {
		DijkstraAlgoSSSP das = new DijkstraAlgoSSSP();
		GraphUsingHashMap graph = new GraphUsingHashMap(das.dijkMap, true);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 1);
		graph.addEdge(1, 3, 7);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 4, 2);
		graph.printGraph();
		Map<Integer, Integer> map = das.shortestPath(1);
		
		for (Map.Entry<Integer, Integer> iter : map.entrySet()) {
			System.out.println(" distance of " + iter.getKey() + " from source is " + iter.getValue());
		}
		
		
		System.out.println("=======================");
		
		das.dijkMap.clear();
		GraphUsingHashMap india = new GraphUsingHashMap(das.dijkMap, true);
		india.addEdge("Amritsar", "Delhi", 1);
		india.addEdge("Amritsar", "Jaipur", 4);
		india.addEdge("Jaipur", "Delhi", 2);
		india.addEdge("Jaipur", "Mumbai", 8);
		india.addEdge("Bhopal", "Agra", 2);
		india.addEdge("Mumbai", "Bhopal", 3);
		india.addEdge("Agra", "Delhi", 1);
		
		india.printGraph();
		
		Map<String, Integer> indiaMap = das.shortestPath("Amritsar");
		
		for (Map.Entry<String, Integer> iter : indiaMap.entrySet()) {
			System.out.println(" distance of " + iter.getKey() + " from source is " + iter.getValue());
		}
	}


	private Map<T, Integer> shortestPath(T source) {
		// TODO Auto-generated method stub
		Map<T, Integer> map = new HashMap<T, Integer>(); 
		map.put(source, 0);
		Map<T, Boolean> isVisted = new HashMap<T, Boolean>();
		
		Queue<T> queue = new LinkedList<T>();
		queue.add(source);
		isVisted.put(source, true);
		
		for (Map.Entry<T, List<GraphWithWeight<Integer>>> node : dijkMap.entrySet()) {
			map.put(node.getKey(), Integer.MAX_VALUE);
		}
		
		map.put(source, 0);
		
		while(!queue.isEmpty()) {
			T node = queue.poll();
			for (GraphWithWeight nodeDetails : dijkMap.get(node)) {
				Integer updatedValue = map.get(node) + (Integer)nodeDetails.nodeValue;
				if(updatedValue < map.get(nodeDetails.nodeKey)) {
					map.put((T) nodeDetails.nodeKey, updatedValue);
				}
				if(isVisted.get((T) nodeDetails.nodeKey) == null || isVisted.get((T) nodeDetails.nodeKey) == false) {
					isVisted.put((T) nodeDetails.nodeKey, true);
					queue.add((T) nodeDetails.nodeKey);
				}
			}
		}
		return map;
	}
}
