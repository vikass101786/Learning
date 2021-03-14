

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NonRepeatingCharacter {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(createNewString(str));
	}

	private static String createNewString(String str) {
		// TODO Auto-generated method stub
		LinkedHashSet<E>
		Character firstNonRep = str.charAt(0);
		String answer = firstNonRep+"";
		queue.add(str.charAt(0));
		
		for (int i = 1 ; i < str.length() ; i++) {
			
			if (str.charAt(i) == firstNonRep) {
				queue.poll();
				queue.add(str.charAt(i));
				
			}
		}
		
		return null;
	}
}
