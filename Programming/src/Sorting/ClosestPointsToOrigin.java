package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ClosestPointsToOrigin {
	
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,-1));
		ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(2,-1));
		//ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(0,0));
		ArrayList<Integer> a4 = new ArrayList<>(Arrays.asList(0,1));
		ArrayList<Integer> a5 = new ArrayList<>(Arrays.asList(1,3));
		ArrayList<Integer> a6 = new ArrayList<>(Arrays.asList(-2,2));
		ArrayList<ArrayList<Integer>> input = new ArrayList<>(Arrays.asList(a1,a2,a4,a5,a6));
		System.out.println(new ClosestPointsToOrigin().solve(input, input.size()));
	}

	public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {

		Comparator<ArrayList<Integer>> pointComparator = new Comparator<ArrayList<Integer>>() {

			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				double distance1 =  Math.sqrt(Math.pow(Math.abs(o1.get(0)), 2) + Math.pow(Math.abs(o1.get(1)), 2));
				double distance2 =  Math.sqrt(Math.pow(Math.abs(o2.get(0)), 2) + Math.pow(Math.abs(o2.get(1)), 2));
				System.out.println(distance1 + " " + distance2);
				if (distance1 > distance2) {
					return 1;
				}
				return -1;
			}
		};
		
		Collections.sort(A, pointComparator);

		return new ArrayList<ArrayList<Integer>>(A.subList(0, B));
	}
}
