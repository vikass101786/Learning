package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CommonEle {
	
	public static void main(String[] args) {
		ArrayList<Integer> A  = new ArrayList<Integer>(Arrays.asList(2, 1, 4, 10));
		ArrayList<Integer> B =  new ArrayList<Integer>(Arrays.asList(3, 6, 2, 10, 10));
		System.out.println(solve(A, B));
	}
	
	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

		int max_ele = Integer.MIN_VALUE;

		for (Integer value : A) {
			max_ele = Math.max(max_ele, value);
		}

		int arr[] = new int[max_ele + 1];

		for (Integer value : A) {
			arr[value]+=1;
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (Integer value : B) {
			if (value < arr.length && arr[value] > 0) {
				list.add(value);
				arr[value]-=1;
			}
		}
		Collections.sort(list);
		return list;
	}
}
