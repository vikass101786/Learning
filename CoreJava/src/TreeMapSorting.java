import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapSorting {
	
	public static void main(String[] args) {
	
		Map<String, Integer> treeMap = new TreeMap<String, Integer>();
		String [] arr = {"The","Day","Zs","Sunny","The","The","The","Zs","Zs","Zs","Sunny"};
		for (int i = 0 ; i < arr.length ; i++) {
			 Integer value = (Integer)treeMap.putIfAbsent(String.valueOf(arr[i]), 1);
			 if(value != null) {
				 treeMap.put(arr[i], value+1);
			 }
		}
		
		final Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				if(o1.getValue().equals(o2.getValue())) {
					return o1.getKey().compareTo(o2.getKey());
				} else {
				    return o2.getValue().compareTo(o1.getValue());	
				}
			}
		};
		
		Set<Map.Entry<String, Integer>> set = treeMap.entrySet();
		SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<Map.Entry<String,Integer>>(comparator);
		sortedSet.addAll(set);
		System.out.println(treeMap);
		System.out.println(sortedSet);
		
	}

	
	
}
