import java.util.Scanner;
import java.util.Stack;

public class _09_StackFibonacci {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = Long.parseLong(console.nextLine());
        long result = 1L;

        Stack<Long> fibonacciNumbers = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(i == 0){
                fibonacciNumbers.push(1L);
                continue;
            }

            if(i == 1){
                fibonacciNumbers.push(1L);
            }

            long numberOne = fibonacciNumbers.pop();
            long numberTwo = fibonacciNumbers.peek();

            fibonacciNumbers.push(numberOne);
            result = numberOne + numberTwo;
            fibonacciNumbers.push(result);
        }

        System.out.println(result);
    }
}