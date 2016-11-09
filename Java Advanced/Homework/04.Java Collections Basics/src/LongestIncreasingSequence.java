import java.util.*;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputLine = console.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputLine.length; i++) {
            numbers.add(Integer.parseInt(inputLine[i]));
        }

        LinkedHashMap<Integer, List<Integer>> numberGroups = new LinkedHashMap<>();
        int groupsCount = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0){
                numberGroups.put(groupsCount, new ArrayList<>());
                numberGroups.get(groupsCount).add(numbers.get(i));
                continue;
            }

            if (numbers.get(i) > numbers.get(i - 1)){
                numberGroups.get(groupsCount).add(numbers.get(i));
                continue;
            }

            groupsCount++;
            numberGroups.put(groupsCount, new ArrayList<>());
            numberGroups.get(groupsCount).add(numbers.get(i));
        }

        int maxSize = 0;
        List<Integer> maxGroup = new ArrayList<>();
        for (List<Integer> value : numberGroups.values()) {
            printNumbers(value);
            if (value.size() > maxSize){
            maxSize = value.size();
            maxGroup.clear();
            maxGroup.addAll(value);
            }
        }

        System.out.print("Longest: ");
        printNumbers(maxGroup);
    }

    private static void printNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1){
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}