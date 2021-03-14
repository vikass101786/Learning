package AdjacencyList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Rotten_Oranges {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int i = 0; i < test_case; i++) {
			int row = sc.nextInt();
			int column = sc.nextInt();
			int freshOranges = 0;
			Queue<PairValue> queue = new LinkedList<PairValue>();
			int arr[][] = new int[row][column];
			for (int k = 0; k < row; k++) {
				for (int j = 0; j < column; j++) {
					arr[k][j] = sc.nextInt();
					if (arr[k][j] == 2) {
						queue.add(new PairValue(k, j, 0));
					} else if (arr[k][j] == 1) {
						freshOranges++;
					}
				}
			}
			System.out.println(minimumTimeTakenToRotenOranges(arr, queue, freshOranges));
		}
	}

	private static int minimumTimeTakenToRotenOranges(int[][] arr, Queue<PairValue> queue, int freshOranges) {
		// TODO Auto-generated method stub

		int row[] = { 0, 0, -1, 1 };
		int column[] = { -1, 1, 0, 0 };
		int max_depth = Integer.MIN_VALUE;
		int total_count = 0;
		while (!queue.isEmpty()) {
			PairValue currentNode = queue.poll();
			for (int i = 0; i < 4; i++) {
					int x = currentNode.rowIndex + row[i];
					int y = currentNode.columIndex + column[i];
					int currentValue = currentNode.value;
					if ((x >= 0 && y >= 0 && x < arr.length && y < arr[0].length) && arr[x][y] == 1) {
						currentValue++;
						arr[x][y] = 2;
						queue.add(new PairValue(x, y, currentValue));
						total_count++;
						max_depth = (max_depth < currentValue) ? currentValue : max_depth;
					}
			}
		}

		return (total_count == freshOranges ? max_depth : -1);
	}

	public static class PairValue {
		int rowIndex;
		int columIndex;
		int value;

		public PairValue(int rowIndex, int columIndex, int value) {
			this.rowIndex = rowIndex;
			this.columIndex = columIndex;
			this.value = value;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[rowIndex] " + rowIndex + " [columIndex] " + columIndex + "[value]" + value;
		}
	}

}
