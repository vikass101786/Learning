package Recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class ClimbingStairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer jumps = sc.nextInt();
		Integer stairs = sc.nextInt();

		System.out.println(jumpsCombination(0, stairs) + "\n");
		System.out.println(jumpsCombination1(jumps, stairs, 0));
		jumpsCombination2(jumps, stairs, 0,"");
		System.out.println();
		System.out.println(jumpsCombinationShortestWay(jumps, stairs, 0));
	}

	private static ArrayList<String> jumpsCombination(Integer jumps, Integer stairs) {

		if (jumps == stairs) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		ArrayList<String> resultList = new ArrayList<String>();
		ArrayList<String> rr1 = jumpsCombination(jumps + 1, stairs);
		for (String value : rr1) {
			resultList.add(1 + value);
		}

		if (jumps + 2 <= stairs) {
			ArrayList<String> rr2 = jumpsCombination(jumps + 2, stairs);
			for (String value : rr2) {
				resultList.add(2 + value);
			}
		}
		if (jumps + 3 <= stairs) {
			ArrayList<String> rr3 = jumpsCombination(jumps + 3, stairs);
			for (String value : rr3) {
				resultList.add(3 + value);
			}
		}
		return resultList;
	}

	private static ArrayList<String> jumpsCombination1(Integer jumps, Integer stairs, Integer source) {

		if (source == stairs) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}
		ArrayList<String> resultList = new ArrayList<String>();
		for (int i = 1; i <= jumps && source + i <= stairs; i++) {
			ArrayList<String> rr1 = jumpsCombination1(jumps, stairs, i+source);
			for (String value : rr1) {
				resultList.add(i + value);
			}
		}
		return resultList;
	}
	
	private static void jumpsCombination2(Integer jumps, Integer stairs, Integer source,String answer) {

		if (source == stairs) {
			System.out.print(answer + ", ");
			return ;
		}
		for (int i = 1; i <= jumps && source + i <= stairs; i++) {
		 jumpsCombination2(jumps, stairs, source + i,i+answer);
			
		}
	}

	private static int jumpsCombinationShortestWay(Integer jumps, Integer stairs, Integer source) {

		if (source == stairs) {
			return 0;
		}
		Integer min_way = Integer.MAX_VALUE;
		for (int i = 1; i <= jumps && source + i <= stairs; i++) {
			min_way = Math.min(jumpsCombinationShortestWay(jumps, stairs, source + i) + 1, min_way);

		}
		return min_way;
	}

}
