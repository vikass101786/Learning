package AdjacencyList;

public class TravelingSalesmanProblem {

	static int dist[][] = { { 0, 20, 42, 25 }, { 20, 0, 30, 34 }, { 42, 30, 0, 10 }, { 25, 34, 10, 0 } };

	static int n = 4;

	static int VISITED_ALL = (1 << n) - 1;

	public static void main(String[] args) {

		System.out.println(tsp(1, 0));

	}

	static int tsp(int mask, int pos) {
		if (VISITED_ALL == mask)
			return dist[pos][0];

		int ans = Integer.MAX_VALUE;
		for (int city = 0; city < n; city++)
			if ((mask & (1 << city)) == 0)
				ans = Math.min(ans, dist[pos][city] + tsp(mask | (1 << city), city));

		return ans;
	}

}
