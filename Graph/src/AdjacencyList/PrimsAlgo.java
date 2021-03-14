package AdjacencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class PrimsAlgo {
	
	public static int totalSum = 0;
	static Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
	static Queue<Pair> queue = new LinkedList<Pair>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total_vertex = sc.nextInt();
		int total_edges = sc.nextInt();
		int source = -1;
		WeightedGraph wgh = new WeightedGraph(map);
		for (int i = 0 ; i < total_edges; i++) {
			int U = sc.nextInt();
			int V = sc.nextInt();
			if (source < 0) {
				source = U;
			}
			int weight = sc.nextInt();
			wgh.addEdge(U,V,weight);
		}
		mst(source,total_vertex);
		
	}
	
	
	public static void mst(int source,int total_vertex) {
		
		Set<Integer> mstSet = new HashSet<Integer>();		
		dfsHelper(mstSet,source,0,total_vertex);
		System.out.println(totalSum);
	}
	
	public static void dfsHelper(Set<Integer> mstSet, Integer source, int sum, int total_vertex) {
	
		mstSet.add(source);
		totalSum += sum;
		
		
		int weight = Integer.MAX_VALUE;
		for (Pair pair : map.get(source)) {
			if (!mstSet.contains(pair.key)) {
				queue.add(pair);
			}
		}
			if(mstSet.size() < total_vertex) {
				Pair currentPair = getMinWeight(mstSet);
			dfsHelper(mstSet, currentPair.key , currentPair.weight,total_vertex);
			}
		
		
	
	}
	
	
	public static Pair getMinWeight(Set<Integer> mstSet ) {
		Integer weight = Integer.MAX_VALUE;
		Pair fiPair = null;
		for (Pair pair : queue) {
			if (pair.weight < weight && !mstSet.contains(pair.key)) {
				fiPair = pair;
				weight = pair.weight;
			}
		}
		queue.remove(fiPair);
		return fiPair; 
	}
	
	
	static class WeightedGraph {
		
		Map<Integer, List<Pair>> map;
		
		WeightedGraph(Map<Integer, List<Pair>> map) {
			this.map = map;
		}
		
		
		public void addEdge(Integer U, Integer V, Integer weight) {
		
			if (map.containsKey(U)) {
				
				map.get(U).add(new Pair(V, weight));
				
			} else {
				List<Pair> list = new ArrayList<Pair>();
				list.add(new Pair(V,weight));
				map.put(U, list);
			
			}
			
			if (map.containsKey(V)) {
				
				map.get(V).add(new Pair(U,weight));
			
			} else {
				List<Pair> list = new ArrayList<Pair>();
				list.add(new Pair(U,weight));
				map.put(V, list);
			
			}
		}
		
	}
	
	static class Pair {
	
	Integer key;
	Integer weight;
	
	Pair(Integer key, Integer weight) {
		this.key = key;
		this.weight = weight;
	}
		
	}
	
}
