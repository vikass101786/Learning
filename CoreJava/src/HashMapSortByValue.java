import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapSortByValue {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaaa", "zzbcd");
		map.put("kasdlh", "bbcd");
		map.put("sdfe", "cbcd");
		map.put("efwe", "dbcd");
		map.put("feww", "ebcd");
		map.put("ewcwe", "fbcd");
		map.put("zzzz", "aafbcd");
		System.out.println(map);
		map = sortByValue(map);
		System.out.println(map);
	}

	private static Map<String, String> sortByValue(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<Map.Entry<String, String>> list = new LinkedList<Map.Entry<String, String>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> o1 , Map.Entry<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		Map<String, String> sortedMap = new LinkedHashMap<String, String>();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

}
