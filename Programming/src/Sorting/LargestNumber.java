package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
	 public String largestNumber(final int[] A) {
	        ArrayList<String> listOfString = new ArrayList<>();
	        for (int value : A) {
	            listOfString.add(value+"");
	        }
	        Comparator<String> stringComparator = new Comparator<String>() {
	            public int compare(String X , String Y) {
	                String XY = X+Y;
	                String YX = Y+X;
	                return XY.compareTo(YX);
	            }
	        };
	        
	        Collections.sort(listOfString , stringComparator);
	        
	        StringBuffer answer = new StringBuffer();
	        
	        for (String value : listOfString)
	         answer.append(value);
	        
	        return new String(answer);
	    }
}
