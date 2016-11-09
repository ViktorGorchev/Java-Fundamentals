import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_SortArrayWithStreamAPI {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputLine = console.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputLine.length; i++) {
            numbers.add(Integer.parseInt(inputLine[i]));
        }

        String sortType = console.nextLine();
        List<Integer> sortedNumbers = new ArrayList<>();
        switch (sortType) {
            case "Ascending":
                sortedNumbers =
                        numbers.stream().sorted((n1, n2) -> Integer.compare(n1, n2)).collect(Collectors.toList());
                //Collections.sort(numbers);
                break;
            case "Descending":
                sortedNumbers =
                        numbers.stream().sorted((n1, n2) -> Integer.compare(n2, n1)).collect(Collectors.toList());
                //Collections.sort(numbers);
                //Collections.reverse(numbers);
                break;
            default:
                break;
        }

        for (Integer number : sortedNumbers) {
            System.out.print(number + " ");
        }
    }
}