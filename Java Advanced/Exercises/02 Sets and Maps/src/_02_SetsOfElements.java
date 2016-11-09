import java.util.HashSet;
import java.util.Scanner;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int firstSetSize = console.nextInt();
        int secondSetSize = console.nextInt();
        console.nextLine();

        HashSet<Integer> firstSet = new HashSet<>();
        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(Integer.parseInt(console.nextLine()));
        }

        HashSet<Integer> secondSet = new HashSet<>();
        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(Integer.parseInt(console.nextLine()));
        }

        firstSet.retainAll(secondSet);

        for (Integer number : firstSet) {
            System.out.print(number + " ");
        }
    }
}
