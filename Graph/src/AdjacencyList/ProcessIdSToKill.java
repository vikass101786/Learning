package AdjacencyList;

import java.util.*;

public class ProcessIdSToKill {

	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int processIdToKill = sc.nextInt();
		int input[] = new int[n];
		int parent[] = new int[n];
		for (int i = 0; i < n; i++)
			input[i] = sc.nextInt();

		for (int i = 0; i < n; i++)
			parent[i] = sc.nextInt();

		Graph graph = new Graph(map);

		for (int i = 0; i < n; i++) {

			if (parent[i] != 0) {
				graph.addEdge(input[i], parent[i]);
			}
		}

		findProcessIdToKill(processIdToKill);
	}

	public static void findProcessIdToKill(int processIdToKill) {

		Set<Integer> set = new LinkedHashSet<Integer>();

		dfs(processIdToKill, set);

		for (Integer iter : set) {

			System.out.print(iter + " ");

		}

	}

	public static void dfs(int processIdToKill, Set<Integer> set) {

		set.add(processIdToKill);

		if (map.get(processIdToKill) != null)
			for (Integer currentId : map.get(processIdToKill)) {
				if (!set.contains(currentId)) {
					dfs(currentId, set);
				}
			}
	}

	public static class Graph {

		Map<Integer, List<Integer>> map;

		Graph(Map<Integer, List<Integer>> map) {
			this.map = map;
		}

		public void addEdge(int child, int parent) {

			if (map.containsKey(parent)) {
				map.get(parent).add(child);
			} else {
				List<Integer> li = new ArrayList<>();
				li.add(child);
				map.put(parent, li);
			}

		}

	}

}