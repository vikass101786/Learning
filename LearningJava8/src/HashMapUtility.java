import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapUtility {

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("key1", Arrays.asList(1, 2, 3, 4));
        map.put("key2", Arrays.asList(4, 5, 6, 7));
        map.put("key3", Arrays.asList(8, 9, 10, 11));
        map.put("key4", Arrays.asList(12, 13, 14, 15));

        List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 3, 4),
                Arrays.asList(4, 5, 6, 7),
                Arrays.asList(8, 9, 10, 11),
                Arrays.asList(12, 13, 14, 15));

        for (Map.Entry<String, List<Integer>> mapIter : map.entrySet()) {
            List<Integer> li = mapIter.getValue();
            for (Integer num : li) {
                if (num % 2 == 0) {
                    System.out.println(num);
                }
            }
        }

        System.out.println(map.values().stream()
                .flatMap(List::stream)
                .filter(num->num%2 == 0)
                .collect(Collectors.toList()));

        map.get("key1").stream()
                .filter(str -> str%2 == 0)
                .collect(Collectors.toList());

        list.stream()
                .flatMap(List::stream)
                .filter(num-> num%2 == 0)
                .collect(Collectors.toList());
    }

}
