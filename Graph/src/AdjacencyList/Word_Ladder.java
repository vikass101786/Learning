package AdjacencyList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Word_Ladder {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String beginWord = sc.next();
		String endWord = sc.next();
		int n = sc.nextInt();
		Set<String> set = new HashSet<String>();
		for (int i = 0 ; i < n ; i++) {
			set.add(sc.next());
		}
		System.out.println(findWordLadder(beginWord,endWord,set));;
	}

	private static int findWordLadder(String beginWord, String endWord, Set<String> set) {
		// TODO Auto-generated method stub
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(beginWord, 1));
		
		while(!queue.isEmpty()) {
			Pair current_word = queue.poll();
			ArrayList<String> neighbour = transformation(current_word,set);
			for (String currentNeigbour : neighbour) {
				if(currentNeigbour.equals(endWord)) {
					return current_word.depth+1;
				} 
				queue.add(new Pair(currentNeigbour, current_word.depth+1));
			}
		}
		return 0;
	}
	
	
	private static ArrayList<String> transformation(Pair current_word, Set<String> set) {
		// TODO Auto-generated method stub
		ArrayList<String> neighbour = new ArrayList<String>();
		StringBuffer sb = new StringBuffer(current_word.word);
		for (int i = 0 ; i < sb.length() ; i++) {
			char temp = sb.charAt(i);
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if(temp == ch) {
					continue;
				}
				 sb.setCharAt(i, ch);
				 String newWord = sb.toString();
				 if(set.remove(newWord)) {
					 neighbour.add(newWord);
				 }
			}
			sb.setCharAt(i, temp);
		}
		return neighbour;
	}


	static class Pair {
		String word;
		int depth;
		public Pair(String word, int depth) {
			this.word=word;
			this.depth=depth;
		}
	}
	
}
