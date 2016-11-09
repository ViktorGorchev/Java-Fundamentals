import java.util.Scanner;

public class _04_CountAllWords {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();
        String[] words = input.split("[^a-zA-Z]+");

        if (words[0].equals("")) {
            System.out.println(words.length - 1);
        } else {
            System.out.println(words.length);
        }
    }
}
