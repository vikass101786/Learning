package ProblemSolving;

import java.util.Arrays;
import java.util.List;

public class Nby3RepeatNumber {
	
	public static void main(String[] args) {
	//	int arr [] = {1000441, 1000441, 1000994};
		List<Integer> list = Arrays.asList(1000441, 1000441, 1000994);
		System.out.println(repeatedNumber(list));
	}
	
	
	public static int repeatedNumber(final List<Integer> a) {
	    int candidateOne = Integer.MAX_VALUE;
	    int candidateTwo = Integer.MAX_VALUE;
	    
	    int candidateOneCount = 0;
	    int candidateTwoCount = 0;
	    
	    for (Integer currentNumber : a) {
	        if (candidateOne == currentNumber) {
	            candidateOneCount++;
	        } else if (candidateTwo == currentNumber) {
	            candidateTwoCount++;
	        } else if (candidateOneCount == 0) {
	            candidateOneCount++;
	            candidateOne = currentNumber;
	        } else if (candidateTwoCount == 0) {
	            candidateTwoCount++;
	            candidateTwo = currentNumber;
	        } else {
	            candidateOneCount--;
	            candidateTwoCount--;
	        }
	    }
	    
	    candidateOneCount = 0;
	    candidateTwoCount = 0;
	    
	    for (Integer currentNumber : a) {
	        if (currentNumber == candidateOneCount) {
	            candidateOneCount++;
	        } else if (currentNumber == candidateTwoCount) {
	            candidateTwoCount++;
	        }
	    }
	    
	    System.out.println(candidateOneCount + "  " + candidateTwoCount + "  " + candidateOne + "  " + candidateTwo);
	    
	     if (candidateOneCount > (a.size()/3)) {
	            System.out.println(candidateOne);
	            return candidateOne;
	        }
	        if (candidateTwoCount > (a.size()/3)) {
	            System.out.println(candidateTwo);
	            return candidateTwo;
	        }
	    
	    return -1;
	}
}
