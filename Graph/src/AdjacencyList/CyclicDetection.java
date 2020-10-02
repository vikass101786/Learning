package AdjacencyList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CyclicDetection<T> {
	
	Map<T, List<T>> cdMap = new HashMap<T, List<T>>();
	
	/*
	 * boolean isCyclic() {
	 * 
	 * Map<T, Boolean> isVisited = new HashMap<T, Boolean>(); Map<T, T> parentNode =
	 * new HashMap<T, T>(); for (Map.Entry<T, List<T>> iterMap : cdMap.entrySet()) {
	 * T node = iterMap.getKey(); isVisited.put(node, true); if(parentNode.get(node)
	 * == null) { parentNode.put(node, node); } for (T currentNode :
	 * iterMap.getValue()) { if((parentNode.get(currentNode) == null ||
	 * parentNode.get(currentNode) != node )) { if(isVisited.get(currentNode) ==
	 * null || isVisited.get(currentNode) != true) { isVisited.put(currentNode,
	 * true); parentNode.put(currentNode, node); } else { return true; } } } }
	 * 
	 * return false; }
	 */
	
	boolean isCyclic(T source) {
		Map<T, Boolean> isVisited = new HashMap<T, Boolean>();
		Map<T, T> parentNode = new HashMap<T, T>();
		Queue<T> queue = new LinkedList<T>(); 
		queue.add(source);
		isVisited.put(source, true);
		parentNode.put(source, source);
		
		while(!queue.isEmpty()) {
			T node = queue.poll();
			for (T neighbour : cdMap.get(node)) {
				if((parentNode.get(neighbour) != null && parentNode.get(node) != neighbour) && (isVisited.get(neighbour) != null && isVisited.get(neighbour) == true)) {
					return true;
				} else if (isVisited.get(neighbour) == null || isVisited.get(neighbour) != true) {
					isVisited.put(neighbour, true);
					parentNode.put(neighbour, source);
					queue.add(neighbour);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CyclicDetection cd = new CyclicDetection();
		GraphUsingHashMap graph = new GraphUsingHashMap(cd.cdMap, true);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 1);
		/*
		 * graph.addEdge(4, 5); graph.addEdge(3, 5); graph.addEdge(5, 6);
		 */
		System.out.println(cd.isCyclic(1));
	}

}
