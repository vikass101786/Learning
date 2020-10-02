package AdjacencyList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstTraversal<T> {
	
	Map<T, List<T>> bfsMap;

	public void BFS(T node) {
		Queue<T> queue = new LinkedList<T>();
		Map<T, Boolean> map = new HashMap<T, Boolean>();
		queue.add(node);
		map.put(node, true);
		
		while(!queue.isEmpty()) {
			T currentNode = queue.poll();
			System.out.print(currentNode + " ");
			
			for (T str : bfsMap.get(currentNode)) {
				if(map.get(str) == null) {
					queue.add(str);
					map.put(str, true);
				}
			}
		}
	}
	
	public void BFSSgortestPath(T node) {
		Queue<T> queue = new LinkedList<T>();
		Map<T,Integer> map = new HashMap<T, Integer>();
		queue.add(node);
		map.put(node, 0);
		while(!queue.isEmpty()) {
			T currentNode = queue.poll();
			for (T str : bfsMap.get(currentNode)) {
				 if(map.get(str) == null) {
					 queue.add(str);
					 map.put(str, map.get(currentNode) + 1);
				 }
			}
		}
		
		for (Map.Entry<T, Integer> iter : map.entrySet()) {
			System.out.println("distance from " + node + " to " + iter.getKey() + " is => " + iter.getValue());
		}
		
	}

	
	public static void main(String[] args) {
		BreadthFirstTraversal<Integer> bfs = new BreadthFirstTraversal<Integer>();
		bfs.bfsMap = new HashMap<Integer, List<Integer>>();
		GraphUsingHashMap<Integer> grap = new GraphUsingHashMap<Integer>(bfs.bfsMap,true);
		grap.addEdge(0, 1);
		grap.addEdge(1, 2);
		grap.addEdge(0, 4);
		grap.addEdge(2, 4);
		grap.addEdge(2, 3);
		grap.addEdge(3, 5);
		grap.addEdge(3, 4);
		
		bfs.BFS(0);
		System.out.println("=================");
		bfs.BFSSgortestPath(5);
	}
}
