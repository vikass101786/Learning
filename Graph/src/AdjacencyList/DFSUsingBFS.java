package AdjacencyList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DFSUsingBFS<T> {
	
	Map<T, List<T>> tlsMap = new HashMap<T, List<T>>();
	
	
	public static void main(String[] args) {
		DFSUsingBFS dfsUbfs = new DFSUsingBFS();
		GraphUsingHashMap graph = new GraphUsingHashMap(dfsUbfs.tlsMap, false);
		graph.addEdge("English", "HTML");
		graph.addEdge("English", "Programming Logic");
		graph.addEdge("Maths", "Programming Logic");
		graph.addEdge("Programming Logic", "HTML");
		graph.addEdge("Programming Logic", "Python");
		graph.addEdge("Programming Logic", "Java");
		graph.addEdge("Programming Logic", "JS");
		graph.addEdge("HTML", "CSS");
		graph.addEdge("CSS", "JS");
		graph.addEdge("JS", "Web Development");
		graph.addEdge("Python", "Web Development");
		graph.addEdge("Java", "Web Development");
		dfsUbfs.tropoLogicSort();
	}



	private void tropoLogicSort() {
		// TODO Auto-generated method stub
		Map<T,Boolean> map = new HashMap<T, Boolean>();
		Queue<T> queue = new LinkedList<T>();
		Map<T, Integer> inEdge = new HashMap<T, Integer>();
		
		for (Map.Entry<T, List<T>> iterMap : tlsMap.entrySet()) {
			T node = iterMap.getKey();
			map.put(node, false);
			inEdge.put(node, 0);
		}
		
		for (Map.Entry<T, List<T>> iterInDeg : tlsMap.entrySet()) {
			for (T node : iterInDeg.getValue()) {
				int value = inEdge.get(node) != null ? inEdge.get(node) : 0;
				inEdge.put(node, value+1);
			}
		}
		
		for (Map.Entry<T, Integer> iterList : inEdge.entrySet()) {
			T node = iterList.getKey();
			if(iterList.getValue() == 0) {
				queue.add(node);
			}
		}
		
		while (!queue.isEmpty()) {
			T node = queue.poll();
			System.out.print(node + " --> ");
			if(tlsMap.get(node)!=null)
			for (T neigbour : tlsMap.get(node)) {
				inEdge.put(neigbour, inEdge.get(neigbour)-1);
				if(inEdge.get(neigbour) == 0) {
					queue.add(neigbour);
				}
			}
		}
		
	}

}
