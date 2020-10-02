package AdjacencyList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadder<T> {

	Map<T, List<T>> bfsMap = new HashMap<T, List<T>>();

	public int bfsShortestPath(T src, T dest) {
		Queue<T> queue = new LinkedList<T>();
		Map<T, Integer> map = new HashMap<T, Integer>();
		Map<T, T> parent = new HashMap<T, T>();
		queue.add(src);
		map.put(src, 0);
		parent.put(src, src);
		System.out.println(bfsMap.size());
		while (!queue.isEmpty()) {
			T currentNode = queue.poll();
			System.out.println(currentNode + "==>" + bfsMap.get(currentNode));
			if (bfsMap.get(currentNode) != null) {
				for (T val : bfsMap.get(currentNode)) {
					if(map.get(val) == null) {
						queue.add(val);
						map.put(val, map.get(currentNode) + 1);
						parent.put(val, currentNode);
					}
				}
			}
		}

		T temp = dest;
		System.out.print(temp + " --> ");
		while (temp != null &&  src != temp) {
			temp = parent.get(temp);
			System.out.print(temp + " --> ");
		}
		System.out.println();
		return map.get(dest);
	}

	public static void main(String[] args) {

		int board[] = new int[50];

		board[2] = 13;
		board[5] = 2;
		board[9] = 18;
		board[18] = 11;
		board[17] = -13;
		board[20] = -14;
		board[24] = -8;
		board[25] = -10;
		board[32] = -2;
		board[34] = -22;

		SnakeAndLadder sandl = new SnakeAndLadder();
		GraphUsingHashMap<Integer> graphUsingHashMap = new GraphUsingHashMap<Integer>(sandl.bfsMap, false);
		for (int u = 0; u < 36; u++) {
			for (int dice = 1; dice <= 6; dice++) {
				int v = u + dice + board[u + dice];
				graphUsingHashMap.addEdge(u, v, false);
			}
		}
		System.out.println(sandl.bfsShortestPath(0, 30));
	}

}
