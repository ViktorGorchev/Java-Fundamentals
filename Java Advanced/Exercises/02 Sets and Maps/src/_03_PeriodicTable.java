import java.util.Scanner;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        TreeSet<String> elementsSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] inputElements = console.nextLine().split("\\s+");
            for (int j = 0; j < inputElements.length; j++) {
                String element = inputElements[j];
                elementsSet.add(element);
            }
        }

        for (String element : elementsSet) {
            System.out.print(element + " ");
        }
    }
}