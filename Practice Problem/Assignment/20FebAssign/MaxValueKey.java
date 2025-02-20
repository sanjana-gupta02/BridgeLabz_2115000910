import java.util.*;

public class MaxValueKey {
    public static String findMaxKey(Map<String, Integer> map) {
        if (map.isEmpty()) return null;

        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        System.out.println("Map: " + map);
        System.out.println("Key with Highest Value: " + findMaxKey(map));
    }
}
