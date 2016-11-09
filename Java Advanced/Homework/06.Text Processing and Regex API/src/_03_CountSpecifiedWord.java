import java.util.Scanner;

public class _03_CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        String lookupWord = console.nextLine().trim().toLowerCase();

        String[] words = input.split("[^a-zA-Z]+");

        int count = 0;
        for (String word : words) {
            if (lookupWord.equals(word.toLowerCase())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
