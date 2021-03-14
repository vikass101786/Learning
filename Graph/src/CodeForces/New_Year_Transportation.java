package CodeForces;

import java.util.*;

public class New_Year_Transportation {
	public static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

	public static void main (String [] args) {
		
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		
			
			Scanner sc = new Scanner(System.in);
			int total_node = sc.nextInt();
			int destination = sc.nextInt();
			Graph graph = new Graph(map);
			for (int i=1; i <total_node; i++) {
			int u = sc.nextInt();
			int v = i+ u;
			graph.addEdge(i,v);
			}
		dfs(1,destination);
		
	}
	
	
	public static void dfs(int source, int destination) {
	
		
			Map<Integer, Boolean> isVisited = new HashMap<Integer, Boolean>();
			String answer = dfsHelper(source,isVisited,destination,"NO");
			System.out.println(answer);
	}



    public static String dfsHelper(int source, Map<Integer,Boolean> isVisited, int destination,String answer) {
	
		
		isVisited.put(source,true);
		
		if (map.get(source) != null)
			
		for (Integer neighbour : map.get(source)) {
				if (neighbour == destination) {
					answer = "Yes";
					break;
				}
				if (isVisited.get(neighbour) == null) {
					answer = dfsHelper(neighbour,isVisited,destination,answer);
				}
		}
		
		return answer;
	}


public static class Graph {

	
	public static Map<Integer, List<Integer>> map ;
	
	Graph( Map<Integer, List<Integer>> map ) {
		
		this.map = map;
		
	}
	
	
	public void addEdge(int u, int v) {
		
		
		if (map.containsKey(u)) {
			
			
			map.get(u).add(v);
			
		
		} else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(v);
			map.put(u,list);
			
		}
	
		
	}
	
	


}



}
