package Recurssion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RatMazeNormal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		List<String> li = ratMaze(0, 0, len, len);
					  ratMaze1(0, 0, len, len,"");
		System.out.println("\n" + li);
	}

	private static ArrayList<String> ratMaze(int sr, int sc, int er, int ec) {
		// TODO Auto-generated method stub
		
		if(sr == er && sc == ec) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		ArrayList<String> resultList = new ArrayList<String>();

		if (sr + 1 <= er) {
			ArrayList<String> liH = ratMaze(sr + 1, sc, er, ec);
			for (String value : liH) {
				resultList.add("H"+value);
			}
		}
		if (sc + 1 <= ec) {
			ArrayList<String> liV = ratMaze(sr, sc + 1, er, ec);
			for (String value : liV) {
				resultList.add("V"+value);
			}
		}
		return resultList;
	}
	private static void ratMaze1(int sr, int sc, int er, int ec,String answer) {

		if(sr == er && sc == ec) {
			System.out.print(answer + ", ");
			return ;
		}

		if (sr + 1 <= er) {
			ratMaze1(sr + 1, sc, er, ec, answer+"H");
		}
		
		if (sc + 1 <= ec) {
			ratMaze1(sr, sc + 1, er, ec, answer+"V");
		}
	}

}
