import java.util.Scanner;

public class CalculateN {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        System.out.println(calculateFactorial(number));
    }

    private static Integer calculateFactorial(int number) {
        if (number == 0){
            return 1;
        }

        return number * calculateFactorial(number - 1);
    }
}