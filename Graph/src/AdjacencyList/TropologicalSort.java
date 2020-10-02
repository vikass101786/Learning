package AdjacencyList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TropologicalSort<T> {
	
	Map<T, List<T>> tlsMap = new HashMap<T, List<T>>();
	
	
	
	public void tropoLogicSort(T source) {
		Map<T, Boolean> map = new HashMap<T, Boolean>();
		List<T> list = new LinkedList<T>();
		for (Map.Entry<T, List<T>> iterMap : tlsMap.entrySet()) {
			T node = iterMap.getKey();
			if(map.get(node) == null || !map.get(node)) {
				tropoLogicSortHelper(map,node,list);
			}
		}
		for (T iter : list) {
		System.out.print(iter + " --> ");
		}
	}
	
	
	private void tropoLogicSortHelper(Map<T, Boolean> map, T source, List<T> list) {
		// TODO Auto-generated method stub
		map.put(source, true);
		if(tlsMap.get(source) != null)
			for (T neighbour : tlsMap.get(source)) {
				if(map.get(neighbour) == null || !map.get(neighbour)) {
				tropoLogicSortHelper(map, neighbour, list);
				}
			}
		list.add(0, source);
	}


	public static void main(String[] args) {
		TropologicalSort tls = new TropologicalSort();
		GraphUsingHashMap graph = new GraphUsingHashMap(tls.tlsMap, false);
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
		tls.tropoLogicSort("English");
	}

}
