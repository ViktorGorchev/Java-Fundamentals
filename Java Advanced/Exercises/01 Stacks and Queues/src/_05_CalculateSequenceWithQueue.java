import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_CalculateSequenceWithQueue {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Long n = Long.parseLong(console.nextLine());
        ArrayDeque<Long> numbers = new ArrayDeque<>();
        numbers.addLast(n);

        for (long i = 0; i < 50; i++) {
            Long current = numbers.removeFirst();
            System.out.print(current + " ");

            Long s1 = current + 1;
            Long s2 = 2 * current + 1;
            Long s3 = current + 2;

            numbers.addLast(s1);
            numbers.addLast(s2);
            numbers.addLast(s3);
        }
    }
}
