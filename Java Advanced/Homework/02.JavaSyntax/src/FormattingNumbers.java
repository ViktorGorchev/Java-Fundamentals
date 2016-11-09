import java.util.Locale;
import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        float b = console.nextFloat();
        float c = console.nextFloat();

        System.out.printf("|%-10s|%010d|%10.2f|%-10.3f|",
                Integer.toHexString(a).toUpperCase(),
                Integer.parseInt(Integer.toBinaryString(a)),
                b,
                c);
    }
}
