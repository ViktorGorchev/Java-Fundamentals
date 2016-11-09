import java.util.Locale;
import java.util.Scanner;

public class GetAverage {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double result = averageNumber(a, b, c);
        System.out.printf("%.2f", result);
    }

    public static double averageNumber(double a, double b, double c){
        double result = (a + b + c) / 3;
        return result;
    }
}


