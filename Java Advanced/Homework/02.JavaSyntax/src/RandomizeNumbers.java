import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomizeNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int m = console.nextInt();

        List<String> resultNumbers = new ArrayList<>();
        for (int i = 0; i < (Integer.max(n, m) + 1) - Integer.min(n, m) ; i++) {
            Random rand = new Random();
            int  number = rand.nextInt((Integer.max(n, m) + 1) - Integer.min(n, m)) + Integer.min(n, m);
            resultNumbers.add(Integer.toString(number));
        }

        System.out.println(String.join(" ", resultNumbers));
    }
}
