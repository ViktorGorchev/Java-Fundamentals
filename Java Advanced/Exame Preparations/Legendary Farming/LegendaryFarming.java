import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {
        Map<String, String> legendaryItems = new HashMap<>();
        legendaryItems.put("shards", "Shadowmourne");
        legendaryItems.put("fragments", "Valanyr");
        legendaryItems.put("motes", "Dragonwrath");

        int neededItemsCount = 250;

        Map<String, Integer> allItems = new TreeMap<>();
        allItems.put("shards", 0);
        allItems.put("fragments", 0);
        allItems.put("motes", 0);

        Scanner console = new Scanner(System.in);

        String input = console.nextLine().toLowerCase();
        String legendaryItem = "";
        while (!input.isEmpty()){
            String[] inputArray = input.split("\\s+");
            int itemCount = 0;
            String item;
            for (int i = 0; i < inputArray.length; i++) {
                if(i % 2 == 0){
                    itemCount = Integer.parseInt(inputArray[i]);
                    continue;
                }

                item = inputArray[i];

                if(!allItems.containsKey(item)){
                    allItems.put(item, 0);
                }

                int sum = allItems.get(item) + itemCount;
                allItems.put(item, sum);
                legendaryItem = legendaryItem(legendaryItems, allItems, neededItemsCount);
                if(legendaryItems.keySet().contains(legendaryItem)){
                    allItems.put(legendaryItem, allItems.get(legendaryItem) - neededItemsCount);
                    break;
                }
            }

            input = console.nextLine().toLowerCase();
        }

        System.out.printf("%s obtained!\n", legendaryItems.get(legendaryItem));
        List<String> keysNotJunk = allItems.keySet().stream().
                filter(item -> legendaryItems.containsKey(item)).
                collect(Collectors.toList());
        LinkedHashMap<String, Integer> mapNotSortedByValue = new LinkedHashMap<>();
        for (String key : keysNotJunk) {
            mapNotSortedByValue.put(key, allItems.get(key));
            allItems.remove(key);
        }

        LinkedHashMap<String, Integer> mapSortedByValue = orderByDescending(mapNotSortedByValue);
        for (Map.Entry <String, Integer> set : mapSortedByValue.entrySet()) {
            System.out.printf("%s: %d\n", set.getKey(), set.getValue());
        }

        for (Map.Entry <String, Integer> set : allItems.entrySet()) {
            System.out.printf("%s: %d\n", set.getKey(), set.getValue());
        }
    }

    private static String legendaryItem(Map<String, String> legendaryItems, Map<String, Integer> allItems, int neededItemsCount) {
        List<String> legemdaryList = allItems.keySet().stream().
                filter(item -> legendaryItems.containsKey(item)).
                filter(item -> allItems.get(item) >= neededItemsCount).collect(Collectors.toList());
        if(legemdaryList.size() > 0){
            return legemdaryList.get(0);
        }

        return null;
    }

    private static LinkedHashMap<String, Integer> orderByDescending(Map<String, Integer> map){
        Object[] a = map.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue().compareTo(
                        ((Map.Entry<String, Integer>) o1).getValue());
            }
        });

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Object e : a) {
            sortedMap.put(((Map.Entry<String, Integer>) e).getKey(), ((Map.Entry<String, Integer>) e).getValue());
        }

        return sortedMap;
    }
}