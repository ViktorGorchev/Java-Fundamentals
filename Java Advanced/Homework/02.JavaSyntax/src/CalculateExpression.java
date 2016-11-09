import java.util.Locale;
import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner console = new Scanner(System.in);
        float a = console.nextFloat();
        float b = console.nextFloat();
        float c = console.nextFloat();

        float resultF1 = (float)Math.pow(
                (Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2)),
                (a + b + c) / Math.sqrt(c));

        float resultF2 = (float)Math.pow(
                Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3),
                a - b);

        float difference = Math.abs(((a + b + c) / 3) - ((resultF1 + resultF2) / 2));

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", resultF1, resultF2, difference);
    }
}