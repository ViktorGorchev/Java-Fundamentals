import java.util.Arrays;
import java.util.Scanner;

public class SortArrayOfNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numbersCount = console.nextInt();

        int[] numbers = new int[numbersCount];
        for (int i = 0; i < numbersCount; i++) {
            numbers[i] = console.nextInt();
        }

        Arrays.sort(numbers);

        for (int number : numbers) {
            System.out.print(number);
            if (number != numbers[numbers.length - 1]) {
                System.out.print(" ");
            }
        }
    }
}