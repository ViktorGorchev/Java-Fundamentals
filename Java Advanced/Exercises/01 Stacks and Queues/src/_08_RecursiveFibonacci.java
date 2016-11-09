import java.util.Scanner;

public class _08_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println(recursiveFibonacci(Long.parseLong(console.nextLine())));
    }

    private static long recursiveFibonacci(Long n)  {
        if (n <= 1) {
            return 1;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }
}