package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ChangeCharacter {
	
	public static void main(String[] args) {
		System.out.println(solve("abcabbccd", 3));
	}
	
	public static int solve(String A, int B) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < A.length(); i++) {
          Character key = A.charAt(i);
          Integer value = map.putIfAbsent(key , 1);
          if (value != null) {
              map.put(key, value+1);
          }
        }
        
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character,Integer>>();
        
        for (Map.Entry<Character, Integer> mapIter : map.entrySet()) {
        	list.add(mapIter);
        }
		
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		Map<Character, Integer> linkMap = new LinkedHashMap<Character, Integer>();
		
		for (Map.Entry<Character, Integer>  liMapIter : list) {
			linkMap.put(liMapIter.getKey(), liMapIter.getValue());
		}
		
		Iterator<Map.Entry<Character, Integer>> mapLiIter = linkMap.entrySet().iterator();
		
		while (mapLiIter.hasNext() && B > 0) {
			int value = mapLiIter.next().getValue();
			if (B >= value) {
				B -= value;
				mapLiIter.remove();
			} else {
				B -= value;
			}
		}
		
        return linkMap.size();
    }
}
