import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int result = 0;
        for (int i = 0; i <= number; i++) {
            result += i;
        }

        System.out.print(result);
    }
}
