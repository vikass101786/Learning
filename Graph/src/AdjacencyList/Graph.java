package AdjacencyList;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	List<Integer> [] list;
	boolean bidirectional = false;
	
	public Graph(int num ,boolean bidirectional) {
		// TODO Auto-generated constructor stub
		this.list = new ArrayList[num];
		this.bidirectional = bidirectional;
		for (int i = 0 ; i < num ; i++) {
			list[i] = new ArrayList<Integer>();
		}
	}
	
	
	public void addEdge(int u, int v) {
		list[u].add(v);
		if(bidirectional) {
			list[v].add(u);
		}	
	}
	
	public void printAdjacencyList() {
		
		for (int i = 0 ; i < list.length ; i++) {
			System.out.print(i + "-> ");
			for (int j = 0 ; j < list[i].size() ; j++) {
				System.out.print(list[i].get(j) +" ,");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(5, true);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(4, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.printAdjacencyList();
	}
	
}
