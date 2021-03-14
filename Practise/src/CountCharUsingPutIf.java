import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharUsingPutIf {
	
	
	public static void main(String[] args) {
		Map<String, Integer> map = countChar("VVIIKASSSHHVV");
		map.forEach((k,v) -> System.out.println(k +" : " + v));
	}
	
	
	public static Map<String, Integer> countChar (String input) {
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (int i = 0 ; i < input.length() ; i++) {
			String currentChar = input.charAt(i)+"";
			map.putIfAbsent(currentChar, 1);
			map.put(currentChar, map.get(currentChar)+1);
		}
		return map;
	}

}
