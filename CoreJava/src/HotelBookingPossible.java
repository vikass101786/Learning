import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class HotelBookingPossible {

	public static void main(String[] args) {
		System.out.println(new HotelBookingPossible().hotel(new ArrayList<Integer>(Arrays.asList(35, 8, 23, 22, 35, 6, 48, 45, 33, 43, 37, 12, 42, 3, 31, 38, 5, 33, 15)),
				new ArrayList<Integer>(Arrays.asList(43, 32, 34, 46, 74, 50, 95, 62, 59, 79, 83, 19, 88, 34, 75, 42, 42, 50, 58)), 11));
	}

	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

		
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 0; i < arrive.size(); i++) {
			Integer arriveValue = map.putIfAbsent(arrive.get(i), 1);
			if (arriveValue != null) {
				map.put(arrive.get(i), arriveValue + 1);
			}
			
			Integer deaprtValue = map.putIfAbsent(depart.get(i), -1);
			if (deaprtValue != null) {
				map.put(depart.get(i), deaprtValue -1);
			}
			
		}

		int value = 0;

		for (Map.Entry<Integer, Integer> hSchedule : map.entrySet()) {
			value += hSchedule.getValue();
			if (K < value) {
				return false;
			}
		}
		return true;
	}
}
