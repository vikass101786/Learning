package AdjacencyList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS<T> {
	
	Map<T, List<T>> adjMap = new HashMap<T, List<T>>();
	
	
	public void dfs(T src) {
		Map<T, Boolean> isVisited = new HashMap<T, Boolean>();
		dfsHelper(isVisited,src);
	}
	
	private void dfsHelper(Map<T, Boolean> isVisited, T src) {
		// TODO Auto-generated method stub
		isVisited.put(src,true);
		System.out.print(src + " --> ");
		if(adjMap.get(src) != null)
		for (T neighbour : adjMap.get(src)) {
			if(isVisited.get(neighbour) == null || !isVisited.get(neighbour)) {
				dfsHelper(isVisited, neighbour);
			}
		}
		
	}

	public static void main(String[] args) {
		DFS dfs = new DFS();
		GraphUsingHashMap graph = new GraphUsingHashMap(dfs.adjMap, false);
		graph.addEdge(0, 1, false);
		graph.addEdge(1, 2, false);
		graph.addEdge(0, 4, false);
		graph.addEdge(2, 4, false);
		graph.addEdge(2, 3, false);
		graph.addEdge(3, 4, false);
		graph.addEdge(3, 5, false);
		dfs.dfs(0);
	}

}
