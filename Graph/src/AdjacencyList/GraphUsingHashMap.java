package AdjacencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GraphUsingHashMap<T> {

	Map<T, List<T>> map;
	boolean bidirectional;

	public GraphUsingHashMap(boolean bidirectional) {
		// TODO Auto-generated constructor stub
		this();
		this.bidirectional = bidirectional;
	}
	
	public GraphUsingHashMap(Map<T, List<T>> map , boolean bidirectional) {
		this.map = map;
		this.bidirectional = bidirectional;
	}
	
	public GraphUsingHashMap() {
		// TODO Auto-generated constructor stub
		map = new HashMap<T, List<T>>();
	}

	public void addEdge(T u, T v) {

		if (map.containsKey(u)) {
			map.get(u).add(v);
		} else {
			List<T> list = new ArrayList<T>();
			list.add(v);
			map.put(u, list);
		}

		if (bidirectional) {
			if (map.containsKey(v)) {
				map.get(v).add(u);
			} else {
				List<T> list = new ArrayList<T>();
				list.add(u);
				map.put(v, list);
			}
		}

	}

	public void addEdge(T u, T v, boolean bidirectional) {

		if (map.containsKey(u)) {
			map.get(u).add(v);
		} else {
			List<T> list = new ArrayList<T>();
			list.add(v);
			map.put(u, list);
		}

		if (bidirectional) {
			if (map.containsKey(v)) {
				map.get(v).add(u);
			} else {
				List<T> list = new ArrayList<T>();
				list.add(u);
				map.put(v, list);
			}
		}

	}

	public void printGraph() {

		for (Entry<T, List<T>> li : map.entrySet()) {
			System.out.print(li.getKey() + " -> ");
			for (T str : li.getValue()) {
				System.out.print(str + " ,");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		GraphUsingHashMap<String> graph = new GraphUsingHashMap<String>(true);
		graph.addEdge("modi", "yogi");
		graph.addEdge("modi", "trump");
		graph.addEdge("prabhu", "modi");
		graph.addEdge("yogi", "prabhu");
		graph.addEdge("putin", "modi");
		graph.addEdge("putin", "trump");
		graph.addEdge("putin", "pope");
		graph.printGraph();

		System.out.println("==========================");

		GraphUsingHashMap<Integer> grapgInt = new GraphUsingHashMap<Integer>(true);
		grapgInt.addEdge(100, 2);
		grapgInt.addEdge(100, 3);
		grapgInt.addEdge(2, 5);
		grapgInt.addEdge(6, 7);
		grapgInt.printGraph();

		System.out.println("==========================");

	}

}
