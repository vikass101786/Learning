package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Bridges {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int query = sc.nextInt();
		while (query-- > 0) {
			int length = sc.nextInt();
			TwoDArray twoDArray[] = new TwoDArray[length];
			for (int i = 0; i < length; i++) {
				twoDArray[i] = new TwoDArray(sc.nextInt(), 0);
			}

			for (int i = 0; i < length; i++) {
				TwoDArray arr = twoDArray[i];
				arr.setSecondPoint(sc.nextInt());
				twoDArray[i] = arr;
			}

			Arrays.sort(twoDArray);

			/*
			 * for (int i = 0 ; i < length ; i++) { System.out.println(twoDArray[i]); }
			 */
			System.out.println(numberOfBridges(twoDArray));
			;
		}
	}

	public static int numberOfBridges(TwoDArray[] twoDArray) {

		int best1 = 1;

		int best2 = 1;

		int n = twoDArray.length;

		int dp1[] = new int[n];

		Arrays.fill(dp1, 1);

		int dp2[] = new int[n];

		Arrays.fill(dp2, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (twoDArray[j].getFirstPoint() < twoDArray[i].getFirstPoint()
						&& twoDArray[j].getSecondPoint() < twoDArray[i].getSecondPoint()) {
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
				}
			}
			best1 = Math.max(dp1[i], best1);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (twoDArray[j].getFirstPoint() > twoDArray[i].getFirstPoint()
						&& twoDArray[j].getSecondPoint() > twoDArray[i].getSecondPoint()) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				}
			}
			best2 = Math.max(dp2[i], best2);
		}
		return Math.max(best1, best2);
	}

	static class TwoDArray implements Comparable<TwoDArray> {
		int firstPoint;
		int secondPoint;

		public TwoDArray(int firstPoint, int secondPoint) {
			this.firstPoint = firstPoint;
			this.secondPoint = secondPoint;
		}

		@Override
		public int compareTo(TwoDArray array) {
			// TODO Auto-generated method stub
			if (array.firstPoint > this.firstPoint) {
				return -1;
			} else if (array.firstPoint == this.firstPoint && array.secondPoint > this.secondPoint) {
				return -1;
			}
			{
				return 1;
			}
		}

		/**
		 * @return the firstPoint
		 */
		public int getFirstPoint() {
			return firstPoint;
		}

		/**
		 * @param firstPoint the firstPoint to set
		 */
		public void setFirstPoint(int firstPoint) {
			this.firstPoint = firstPoint;
		}

		/**
		 * @return the secondPoint
		 */
		public int getSecondPoint() {
			return secondPoint;
		}

		/**
		 * @param secondPoint the secondPoint to set
		 */
		public void setSecondPoint(int secondPoint) {
			this.secondPoint = secondPoint;
		}

		@Override
		public String toString() {
			return "TwoDArray [firstPoint=" + firstPoint + ", secondPoint=" + secondPoint + "]";
		}

	}
}
