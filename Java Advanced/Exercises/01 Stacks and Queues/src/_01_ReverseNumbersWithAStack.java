import java.util.Scanner;
import java.util.Stack;

public class _01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");

        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < input.length; i++) {
          numbers.push(Integer.parseInt(input[i]));
        }

        int setSize =  numbers.size();
        for (int i = 0; i <setSize; i++) {
            System.out.print(numbers.pop() + " ");
        }
    }
}