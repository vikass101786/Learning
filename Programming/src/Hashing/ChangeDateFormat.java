package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ChangeDateFormat {
	public static void main(String[] args) {
		System.out.println(new ChangeDateFormat().solve("3rd Jul 3532"));
	}
	static Map<String, String> map = new HashMap<>();
    static {
        map.put("Jan","01");
        map.put("Feb","02");
        map.put("Mar","03");
        map.put("Apr","04");
        map.put("May","05");
        map.put("Jun","06");
        map.put("Jul","07");
        map.put("Aug","08");
        map.put("Sep","09");
        map.put("Oct","10");
        map.put("Nov","11");
        map.put("Dec","12");
    }
    public String solve(String A) {
        String arr [] = A.split(" ");
        return arr[2]+"-"+map.get(arr[1])+"-"+
        		(arr[0].substring(0,arr[0].length()-2).length() == 1 ? 
        				0+arr[0].substring(0,arr[0].length()-2) :
        					arr[0].substring(0,arr[0].length()-2)) ;
    }
}
